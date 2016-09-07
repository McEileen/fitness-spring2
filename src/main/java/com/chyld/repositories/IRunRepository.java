package com.chyld.repositories;

import com.chyld.entities.Run;
import com.chyld.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IRunRepository extends PagingAndSortingRepository<Run, Integer> {
    public Run findById(int Id);
}
