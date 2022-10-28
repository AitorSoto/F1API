package com.f1.records.controllers;

import com.f1.records.pojos.DTOs.QualifyingDTO;
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
    public ResponseEntity<List<QualifyingDTO>> allQualifyings(@RequestParam(defaultValue = "0") Integer pageNo,
                                                              @RequestParam(defaultValue = "10") Integer pageSize,
                                                              @RequestParam(required = false) String sortBy) {
        List<QualifyingDTO> qualifyingDTOs = null;
        if(sortBy != null)
            qualifyingDTOs = qualifyingService.getAllQualys(pageNo, pageSize, sortBy);
        else
            qualifyingDTOs = qualifyingService.getAllQualys(pageNo, pageSize);

        return new ResponseEntity<>(qualifyingDTOs, HttpStatus.OK);
    }

    @GetMapping(value = "/qualifyings/{raceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<QualifyingDTO>> qualifyingsByRaceId(@PathVariable("raceId") int raceId,
                                                                   @RequestParam(defaultValue = "0") Integer pageNo,
                                                                   @RequestParam(defaultValue = "10") Integer pageSize,
                                                                   @RequestParam(required = false) String sortBy) {
        List<QualifyingDTO> qualifyingDTOs = null;
        if(sortBy != null)
            qualifyingDTOs = qualifyingService.getAllQualysByRaceId(raceId, pageNo, pageSize, sortBy);
        else
            qualifyingDTOs = qualifyingService.getAllQualysByRaceId(raceId, pageNo, pageSize);

        return new ResponseEntity<>(qualifyingDTOs, HttpStatus.OK);
    }

    @GetMapping(value = "/qualifyings/{raceId}/{constructorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<QualifyingDTO>> qualifyingByRaceIdAndConstructorId(  @PathVariable("raceId") int raceId,
                                                                                    @PathVariable("constructorId") int constructorId) {
        List<QualifyingDTO> qualifyingDAOS = qualifyingService.getAllQualysByRaceIdAndConstructorId(raceId, constructorId);

        return new ResponseEntity<>(qualifyingDAOS, HttpStatus.OK);
    }

    @GetMapping(value = "/qualifying/{raceId}/{driverId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QualifyingDTO> qualifyingByRaceIdAndDriverId(@PathVariable("raceId") int raceId,
                                                                       @PathVariable("driverId") int driverId) {
        QualifyingDTO qualifyingDTO = qualifyingService.getQualyByRaceIdAndDriverId(raceId, driverId);

        return new ResponseEntity<>(qualifyingDTO, HttpStatus.OK);
    }
}
