package com.f1.records.repositorys;

import com.f1.records.pojos.DTOs.Driver;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository  extends PagingAndSortingRepository<Driver, Integer> {
    Driver getDriverBySurname(String surname);
}
