package com.chyld.controllers;

import com.chyld.entities.Device;
import com.chyld.entities.Exercise;
import com.chyld.entities.Run;
import com.chyld.entities.User;
import com.chyld.security.JwtToken;
import com.chyld.services.DeviceService;
import com.chyld.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/runs")
public class RunController {

    @Autowired
    private DeviceService deviceService;
    private UserService userService;

    @Autowired
    private void setDeviceService(DeviceService deviceService)  {
        this.deviceService = deviceService;
    };

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Run> getRuns(Principal user) {
        int uid = ((JwtToken)user).getUserId();
        User u = userService.findUserById(uid);
        Device d1 = u.getDevices().get(0);
        return d1.getRuns();
    }

    @RequestMapping(value = "/{deviceId}/start", method = RequestMethod.POST)
    public Run startRun(@PathVariable int deviceId) {

        Device myDevice = deviceService.findDeviceById(deviceId);

        List<Run> runs = myDevice.getRuns();
        for (Run r : runs) {
            if (r.getEndTime() == null) {
                return new Run(); //error
            }
        }

        Run r = new Run();
        r.setDevice(myDevice);
        Date myDate = new Date();
        r.setStartTime(myDate);
        r.setCreated(myDate);
        r.setModified(myDate);
        List<Run> updatedRuns = myDevice.getRuns();
        updatedRuns.add(r);
        myDevice.setRuns(updatedRuns);
        deviceService.saveDevice(myDevice);
        return r;


//        Optional<Run> openRun = runs.stream().filter(r -> r.getEndTime().equals(null)).findFirst();
//
//        if (openRun.isPresent()) {
//            return new Run();
//        }
        //if not found create a run
    }

    @RequestMapping(value = "/{deviceId}/stop", method = RequestMethod.POST)
    public Run stopRun(Principal user, @PathVariable int deviceId) {
        int uid = ((JwtToken)user).getUserId();
        User u = userService.findUserById(uid);
        List<Device> devices = u.getDevices();

        Run openRun = null;
        for (Device d : devices) {
            if (d.getId() == deviceId) {
                List<Run> runs = d.getRuns();
                for (Run r : runs) {
                    if (r.getEndTime() == null) {
                        r.setEndTime(new Date());
                        openRun = r;
                    }
                }
                List<Run> updatedRuns = d.getRuns();
                updatedRuns.add(openRun);
                d.setRuns(updatedRuns);
                userService.saveUser(u);
                return openRun;
            }
        }
        return new Run(); //error - not found device
    }
}
