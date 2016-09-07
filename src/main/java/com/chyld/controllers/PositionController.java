package com.chyld.controllers;

import com.chyld.entities.*;
import com.chyld.security.JwtToken;
import com.chyld.services.DeviceService;
import com.chyld.services.RunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/positions")
public class PositionController {
    private RunService runService;
    private DeviceService deviceService;

    @Autowired
    private void setRunService(RunService runService)  {
        this.runService = runService;
    };

    @Autowired
    private void setDeviceService(DeviceService deviceService)  {
        this.deviceService = deviceService;
    };

    @RequestMapping(value = "/{deviceId}", method = RequestMethod.POST)
    public Position createPosition(Principal user, @PathVariable int deviceId,  @RequestBody Position newPosition) {

        Device myDevice = deviceService.findDeviceById(deviceId);
        List<Run> allRuns = myDevice.getRuns();
        Run myRun = null;

        for (Run r : allRuns) {
            if (r.getEndTime() == null) {
                newPosition.setRun(r);
                myRun = r;
            }
        }

        if (newPosition.getRun() == null) {
            return new Position();
        }

        // if there is an open run, add this position to the list of positions
        List<Position> updatedPositions = myRun.getPositions();
        updatedPositions.add(newPosition);
        runService.saveRun(myRun);
        return newPosition;
        }

}
