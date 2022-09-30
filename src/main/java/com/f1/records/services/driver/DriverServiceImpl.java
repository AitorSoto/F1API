package com.f1.records.services.driver;

import com.f1.records.pojos.Driver;
import com.f1.records.repositorys.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService{
    @Autowired
    DriverRepository driverRepository;

    @Override
    public List<Driver> findAllDrivers(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Driver> drivers = driverRepository.findAll(pageable);

        return drivers.getContent();
    }

    @Override
    public List<Driver> findAllDrivers(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Driver> drivers = driverRepository.findAll(pageable);

        return drivers.getContent();
    }

    @Override
    public Driver findDriverBySurname(String surname) {
        return driverRepository.getDriverBySurname(surname);
    }
}
