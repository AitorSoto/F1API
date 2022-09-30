package com.f1.records.controllers;

import com.f1.records.pojos.Driver;
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
    public ResponseEntity<List<Driver>> findAllDrivers(@RequestParam(defaultValue = "0") Integer pageNo,
                                                         @RequestParam(defaultValue = "10") Integer pageSize,
                                                         @RequestParam(required = false) String sortBy) {
        List<Driver> drivers = null;
        if(sortBy != null)
            drivers = driverService.findAllDrivers(pageNo, pageSize, sortBy);
        else
            drivers = driverService.findAllDrivers(pageNo, pageSize);

        return new ResponseEntity<>(drivers, HttpStatus.OK);
    }

    @GetMapping(value = "/drivers/{surname}")
    public ResponseEntity<Driver> findDriverBySurname(@PathVariable String surname) {
        Driver driver = driverService.findDriverBySurname(surname);
        return new ResponseEntity<>(driver, HttpStatus.OK);
    }
}
