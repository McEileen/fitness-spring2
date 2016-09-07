package com.chyld.services;

import com.chyld.entities.Run;
import com.chyld.entities.User;
import com.chyld.repositories.IRunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class RunService {
    private IRunRepository repository;

    @Autowired
    public void setRepository(IRunRepository repository) {
        this.repository = repository;
    }

    public Run saveRun(Run run) {
        return repository.save(run);
    }

    public Run findRunById(Integer id) {
        return repository.findOne(id);
    }

}
