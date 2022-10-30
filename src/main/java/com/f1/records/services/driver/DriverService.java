package com.f1.records.services.driver;

import com.f1.records.pojos.DAOs.DriverDAO;
import com.f1.records.pojos.DTOs.DriverDTO;

import java.util.List;

public interface DriverService {
    List<DriverDTO> findAllDrivers(int pageNo, int pageSize, String sortBy);
    List<DriverDTO> findAllDrivers(int pageNo, int pageSize);
    DriverDTO findDriverBySurname(String forename, String surname);
}
