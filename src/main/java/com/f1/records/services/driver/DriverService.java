package com.f1.records.services.driver;

import com.f1.records.pojos.Driver;

import java.util.List;

public interface DriverService {
    List<Driver> findAllDrivers(int pageNo, int pageSize, String sortBy);
    List<Driver> findAllDrivers(int pageNo, int pageSize);
    Driver findDriverBySurname(String surname);
}
