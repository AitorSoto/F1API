package com.f1.records.services.driver;

import com.f1.records.pojos.DAOs.DriverDAO;
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
    public List<DriverDAO> findAllDrivers(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<DriverDAO> drivers = driverRepository.findAll(pageable);

        return drivers.getContent();
    }

    @Override
    public List<DriverDAO> findAllDrivers(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<DriverDAO> drivers = driverRepository.findAll(pageable);

        return drivers.getContent();
    }

    @Override
    public DriverDAO findDriverBySurname(String surname) {
        return driverRepository.getDriverDTOBySurname(surname);
    }
}
