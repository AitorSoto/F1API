package com.f1.records.controllers;

import com.f1.records.pojos.DAOs.DriverDAO;
import com.f1.records.services.driver.DriverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriverController {
    @Autowired
    DriverServiceImpl driverService;

    @GetMapping(value = "/drivers")
    public ResponseEntity<List<DriverDAO>> findAllDrivers(@RequestParam(defaultValue = "0") Integer pageNo,
                                                          @RequestParam(defaultValue = "10") Integer pageSize,
                                                          @RequestParam(required = false) String sortBy) {
        List<DriverDAO> driverDAOS = null;
        if(sortBy != null)
            driverDAOS = driverService.findAllDrivers(pageNo, pageSize, sortBy);
        else
            driverDAOS = driverService.findAllDrivers(pageNo, pageSize);

        return new ResponseEntity<>(driverDAOS, HttpStatus.OK);
    }

    @GetMapping(value = "/drivers/{surname}")
    public ResponseEntity<DriverDAO> findDriverBySurname(@PathVariable String surname) {
        DriverDAO driverDAO = driverService.findDriverBySurname(surname);
        return new ResponseEntity<>(driverDAO, HttpStatus.OK);
    }
}
