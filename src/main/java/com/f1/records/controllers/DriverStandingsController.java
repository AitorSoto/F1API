package com.f1.records.controllers;

import com.f1.records.pojos.DAOs.DriverStandingDAO;
import com.f1.records.services.driverStandingsService.DriverStandingsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DriverStandingsController {
    @Autowired
    DriverStandingsServiceImpl driverStandingsService;

    @GetMapping(value = "/driversStandings")
    public ResponseEntity<List<DriverStandingDAO>> findAllDriversStandings(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                                                           @RequestParam(required = false) String sortBy) {
        List<DriverStandingDAO> driverStandingDAOS = null;
        if(sortBy != null)
            driverStandingDAOS = driverStandingsService.findAllDriverStandings(pageNo, pageSize, sortBy);
        else
            driverStandingDAOS = driverStandingsService.findAllDriverStandings(pageNo, pageSize);

        return new ResponseEntity<>(driverStandingDAOS, HttpStatus.OK);
    }

    @GetMapping(value = "/driversStandingsById/{driverId}")
    public ResponseEntity<List<DriverStandingDAO>> findDriverStandingsByDriver(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                               @RequestParam(defaultValue = "10") Integer pageSize,
                                                                               @RequestParam(required = false) String sortBy,
                                                                               @PathVariable int driverId) {
        List<DriverStandingDAO> driverStandingDAOS = null;
        if(sortBy != null)
            driverStandingDAOS = driverStandingsService.findDriverStandingsByDriverId(pageNo, pageSize, sortBy, driverId);
        else
            driverStandingDAOS = driverStandingsService.findDriverStandingsByDriverId(pageNo, pageSize, driverId);

        return new ResponseEntity<>(driverStandingDAOS, HttpStatus.OK);
    }

    @GetMapping(value = "/driversStandingsById/{driverId}/{raceId}")
    public ResponseEntity<DriverStandingDAO> findDriverStandingsByDriverAndRace(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                                @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                @RequestParam(required = false) String sortBy,
                                                                                @PathVariable int driverId,
                                                                                @PathVariable int raceId) {
        DriverStandingDAO driverStandingDAO = null;
        if(sortBy != null)
            driverStandingDAO = driverStandingsService.findDriverStandingsByDriverIdAndRaceId(pageNo, pageSize, sortBy, driverId, raceId);
        else
            driverStandingDAO = driverStandingsService.findDriverStandingsByDriverIdAndRaceId(pageNo, pageSize, driverId, raceId);

        return new ResponseEntity<>(driverStandingDAO, HttpStatus.OK);
    }
}
