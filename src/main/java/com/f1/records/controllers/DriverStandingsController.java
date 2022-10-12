package com.f1.records.controllers;

import com.f1.records.pojos.DTOs.DriverStanding;
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
    public ResponseEntity<List<DriverStanding>> findAllDriversStandings(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                        @RequestParam(defaultValue = "10") Integer pageSize,
                                                                        @RequestParam(required = false) String sortBy) {
        List<DriverStanding> driverStandings = null;
        if(sortBy != null)
            driverStandings = driverStandingsService.findAllDriverStandings(pageNo, pageSize, sortBy);
        else
            driverStandings = driverStandingsService.findAllDriverStandings(pageNo, pageSize);

        return new ResponseEntity<>(driverStandings, HttpStatus.OK);
    }

    @GetMapping(value = "/driversStandingsById/{driverId}")
    public ResponseEntity<List<DriverStanding>> findDriverStandingsByDriver(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                            @RequestParam(defaultValue = "10") Integer pageSize,
                                                                            @RequestParam(required = false) String sortBy,
                                                                            @PathVariable int driverId) {
        List<DriverStanding> driverStandings = null;
        if(sortBy != null)
            driverStandings = driverStandingsService.findDriverStandingsByDriverId(pageNo, pageSize, sortBy, driverId);
        else
            driverStandings = driverStandingsService.findDriverStandingsByDriverId(pageNo, pageSize, driverId);

        return new ResponseEntity<>(driverStandings, HttpStatus.OK);
    }

    @GetMapping(value = "/driversStandingsById/{driverId}/{raceId}")
    public ResponseEntity<DriverStanding> findDriverStandingsByDriverAndRace(   @RequestParam(defaultValue = "0") Integer pageNo,
                                                                                @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                @RequestParam(required = false) String sortBy,
                                                                                @PathVariable int driverId,
                                                                                @PathVariable int raceId) {
        DriverStanding driverStanding = null;
        if(sortBy != null)
            driverStanding = driverStandingsService.findDriverStandingsByDriverIdAndRaceId(pageNo, pageSize, sortBy, driverId, raceId);
        else
            driverStanding = driverStandingsService.findDriverStandingsByDriverIdAndRaceId(pageNo, pageSize, driverId, raceId);

        return new ResponseEntity<>(driverStanding, HttpStatus.OK);
    }
}
