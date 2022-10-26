package com.f1.records.controllers;

import com.f1.records.pojos.DAOs.QualifyingDAO;
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
    public ResponseEntity<List<QualifyingDAO>> allQualifyings(@RequestParam(defaultValue = "0") Integer pageNo,
                                                              @RequestParam(defaultValue = "10") Integer pageSize,
                                                              @RequestParam(required = false) String sortBy) {
        List<QualifyingDAO> qualifyingDAOS = null;
        if(sortBy != null)
            qualifyingDAOS = qualifyingService.getAllQualys(pageNo, pageSize, sortBy);
        else
            qualifyingDAOS = qualifyingService.getAllQualys(pageNo, pageSize);

        return new ResponseEntity<>(qualifyingDAOS, HttpStatus.OK);
    }

    @GetMapping(value = "/qualifyings/{raceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<QualifyingDAO>> qualifyingsByRaceId(@PathVariable("raceId") int raceId,
                                                                   @RequestParam(defaultValue = "0") Integer pageNo,
                                                                   @RequestParam(defaultValue = "10") Integer pageSize,
                                                                   @RequestParam(required = false) String sortBy) {
        List<QualifyingDAO> qualifyingDAOS = null;
        if(sortBy != null)
            qualifyingDAOS = qualifyingService.getAllQualysByRaceId(raceId, pageNo, pageSize, sortBy);
        else
            qualifyingDAOS = qualifyingService.getAllQualysByRaceId(raceId, pageNo, pageSize);

        return new ResponseEntity<>(qualifyingDAOS, HttpStatus.OK);
    }

    @GetMapping(value = "/qualifyings/{raceId}/{constructorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<QualifyingDAO>> mecagoentusmuelas(@PathVariable("raceId") int raceId,
                                                                 @PathVariable("constructorId") int constructorId) {
        List<QualifyingDAO> qualifyingDAOS = qualifyingService.getAllQualysByRaceIdAndConstructorId(raceId, constructorId);

        return new ResponseEntity<>(qualifyingDAOS, HttpStatus.OK);
    }

    @GetMapping(value = "/qualifying/{raceId}/{driverId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QualifyingDAO> qualifyingByRaceIdAndDriverId(@PathVariable("raceId") int raceId,
                                                                       @PathVariable("driverId") int driverId) {
        QualifyingDAO qualifyingDAO = qualifyingService.getQualyByRaceIdAndDriverId(raceId, driverId);

        return new ResponseEntity<>(qualifyingDAO, HttpStatus.OK);
    }
}
