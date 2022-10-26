package com.f1.records.services.driver;

import com.f1.records.pojos.DAOs.DriverDAO;

import java.util.List;

public interface DriverService {
    List<DriverDAO> findAllDrivers(int pageNo, int pageSize, String sortBy);
    List<DriverDAO> findAllDrivers(int pageNo, int pageSize);
    DriverDAO findDriverBySurname(String surname);
}
