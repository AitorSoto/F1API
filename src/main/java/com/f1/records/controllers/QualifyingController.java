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

    @GetMapping(value = "/qualifyings/byId/{raceId}", produces = MediaType.APPLICATION_JSON_VALUE)
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

    @GetMapping(value = "/qualifyings/byId/{raceId}/{constructorId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<QualifyingDTO>> qualifyingByRaceIdAndConstructorId(  @RequestParam(defaultValue = "0") Integer pageNo,
                                                                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                    @RequestParam(required = false) String sortBy,
                                                                                    @PathVariable("raceId") int raceId,
                                                                                    @PathVariable("constructorId") int constructorId) {

        List<QualifyingDTO> qualifyingDAOS = null;
        if(sortBy == null)
            qualifyingService.getAllQualysByRaceIdAndConstructorId(pageNo, pageSize, raceId, constructorId);
        else
            qualifyingService.getAllQualysByRaceIdAndConstructorId(pageNo, pageSize, sortBy, raceId, constructorId);

        return new ResponseEntity<>(qualifyingDAOS, HttpStatus.OK);
    }

    @GetMapping(value = "/qualifying/byId/{raceId}/{driverId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QualifyingDTO> qualifyingByRaceIdAndDriverId(@PathVariable("raceId") int raceId,
                                                                       @PathVariable("driverId") int driverId) {
        QualifyingDTO qualifyingDTO = qualifyingService.getQualyByRaceIdAndDriverId(raceId, driverId);

        return new ResponseEntity<>(qualifyingDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/qualifying/byname/{raceName}/{constructorName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<QualifyingDTO>> getQualifyingByRaceNameAndConstructorName(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                                         @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                         @RequestParam(required = false) String sortBy,
                                                                                         @PathVariable("raceName") String raceName,
                                                                                         @PathVariable("constructorName") String constructorName) {
        List<QualifyingDTO> qualifyingDTOS = null;
        if(sortBy == null)
            qualifyingDTOS = qualifyingService.getQualifyingByRaceNameAndConstructorName(pageNo, pageSize, raceName, constructorName);
        else
            qualifyingDTOS = qualifyingService.getQualifyingByRaceNameAndConstructorName(pageNo, pageSize, sortBy, raceName, constructorName);

        return new ResponseEntity<>(qualifyingDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/qualifying/byName/{raceName}/{driverFullName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<QualifyingDTO>> getQualifyingByRaceNameAndDriverFullName(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                                        @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                        @RequestParam(required = false) String sortBy,
                                                                                        @PathVariable("raceName") String raceName,
                                                                                        @PathVariable("driverFullName") String driverFullName) {
        String forename, surname;
        forename = driverFullName.split(" ")[0];
        surname = driverFullName.split(" ")[1];
        List<QualifyingDTO> qualifyingDTOS = null;
        if(sortBy == null)
            qualifyingDTOS = qualifyingService.getQualifyingByRaceNameAndDriverFullName(pageNo, pageSize, raceName, forename, surname);
        else
            qualifyingDTOS = qualifyingService.getQualifyingByRaceNameAndDriverFullName(pageNo, pageSize, sortBy, raceName, forename, surname);

        return new ResponseEntity<>(qualifyingDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/qualifyings/byName/{raceName}/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<QualifyingDTO>> getQualifyingByRaceNameAndRaceYear(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                                  @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                  @RequestParam(required = false) String sortBy,
                                                                                  @PathVariable("raceName") String raceName,
                                                                                  @PathVariable("year") int year) {
        List<QualifyingDTO> qualifyingDTOS = null;
        if(sortBy == null)
            qualifyingDTOS = qualifyingService.getQualifyingByRaceNameAndRaceYear(pageNo, pageSize, raceName, year);
        else
            qualifyingDTOS = qualifyingService.getQualifyingByRaceNameAndRaceYear(pageNo, pageSize, sortBy, raceName, year);

        return new ResponseEntity<>(qualifyingDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "/qualifyings/byName/{raceName}/{year}/{driverFullName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<QualifyingDTO> getQualifyingByRaceNameAndRaceYearAndDriverFullName(@PathVariable("raceName") String raceName,
                                                                                                   @PathVariable("year") int year,
                                                                                                   @PathVariable("driverFullName") String driverFullName) {
        String forename, surname;
        forename = driverFullName.split(" ")[0];
        surname = driverFullName.split(" ")[1];
        QualifyingDTO qualifyingDTO =
                qualifyingService.getQualifyingByRaceNameAndRaceYearAndDriverFullName(raceName, year, forename, surname);
        return new ResponseEntity<>(qualifyingDTO, HttpStatus.OK);
    }


}
