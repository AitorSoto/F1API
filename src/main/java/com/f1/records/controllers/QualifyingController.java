package com.f1.records.controllers;

import com.f1.records.pojos.DTOs.Qualifying;
import com.f1.records.services.qualifying.QualifyingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QualifyingController {
    @Autowired
    QualifyingServiceImpl qualifyingService;

    @GetMapping(value = "/qualifyings", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Qualifying>> allQualifyings( @RequestParam(defaultValue = "0") Integer pageNo,
                                                                @RequestParam(defaultValue = "10") Integer pageSize,
                                                                @RequestParam(required = false) String sortBy) {
        List<Qualifying> qualifyings = null;
        if(sortBy != null)
            qualifyings = qualifyingService.getAllQualys(pageNo, pageSize, sortBy);
        else
            qualifyings = qualifyingService.getAllQualys(pageNo, pageSize);

        return new ResponseEntity<>(qualifyings, HttpStatus.OK);
    }

    @GetMapping(value = "/qualifyings/{raceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Qualifying>> qualifyingsByRaceId(  @PathVariable("raceId") int raceId,
                                                                      @RequestParam(defaultValue = "0") Integer pageNo,
                                                                      @RequestParam(defaultValue = "10") Integer pageSize,
                                                                      @RequestParam(required = false) String sortBy) {
        List<Qualifying> qualifyings = null;
        if(sortBy != null)
            qualifyings = qualifyingService.getAllQualysByRaceId(raceId, pageNo, pageSize, sortBy);
        else
            qualifyings = qualifyingService.getAllQualysByRaceId(raceId, pageNo, pageSize);

        return new ResponseEntity<>(qualifyings, HttpStatus.OK);
    }

    @GetMapping(value = "/qualifyings/{raceId}/{constructorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Qualifying>> mecagoentusmuelas(@PathVariable("raceId") int raceId,
                                                              @PathVariable("constructorId") int constructorId) {
        List<Qualifying> qualifyings = qualifyingService.getAllQualysByRaceIdAndConstructorId(raceId, constructorId);

        return new ResponseEntity<>(qualifyings, HttpStatus.OK);
    }

    @GetMapping(value = "/qualifying/{raceId}/{driverId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Qualifying> qualifyingByRaceIdAndDriverId(@PathVariable("raceId") int raceId,
                                                                    @PathVariable("driverId") int driverId) {
        Qualifying qualifying = qualifyingService.getQualyByRaceIdAndDriverId(raceId, driverId);

        return new ResponseEntity<>(qualifying, HttpStatus.OK);
    }
}
