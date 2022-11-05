package com.f1.records.controllers;

import com.f1.records.pojos.DTOs.PitStopDTO;
import com.f1.records.services.pitStopService.PitStopServiceImpl;
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
public class PitStopController {
    @Autowired
    PitStopServiceImpl pitStopService;

    @GetMapping(value = "/pitstops", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PitStopDTO>> findAllPitStops(@RequestParam(defaultValue = "0") Integer pageNo,
                                                            @RequestParam(defaultValue = "10") Integer pageSize,
                                                            @RequestParam(required = false) String sortBy) {
        List<PitStopDTO> pitstops = null;
        if(sortBy != null)
            pitstops = pitStopService.findAllPitStops(pageNo, pageSize, sortBy);
        else
            pitstops = pitStopService.findAllPitStops(pageNo, pageSize);

        return new ResponseEntity<>(pitstops, HttpStatus.OK);
    }

    @GetMapping(value = "/pitstops/byId/{driverId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PitStopDTO>> findAllPitStopsByDriverId(@PathVariable() int driverId,
                                                                      @RequestParam(defaultValue = "0") Integer pageNo,
                                                                      @RequestParam(defaultValue = "10") Integer pageSize,
                                                                      @RequestParam(required = false) String sortBy) {
        List<PitStopDTO> pitstops = null;
        if(sortBy != null)
            pitstops = pitStopService.findByDriverId(driverId, pageNo, pageSize, sortBy);
        else
            pitstops = pitStopService.findByDriverId(driverId, pageNo, pageSize);

        return new ResponseEntity<>(pitstops, HttpStatus.OK);
    }

    @GetMapping(value = "/pitstops/byId/{driverId}/{raceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PitStopDTO>> findAllPitStopsByDriverIdAndRaceId(@PathVariable() int driverId,
                                                                               @PathVariable() int raceId,
                                                                               @RequestParam(defaultValue = "0") Integer pageNo,
                                                                               @RequestParam(defaultValue = "10") Integer pageSize,
                                                                               @RequestParam(required = false) String sortBy) {
        List<PitStopDTO> pitstops = null;
        if(sortBy != null)
            pitstops = pitStopService.findByDriverIdAndRaceId(driverId, raceId,pageNo, pageSize, sortBy);
        else
            pitstops = pitStopService.findByDriverIdAndRaceId(driverId, raceId,pageNo, pageSize);

        return new ResponseEntity<>(pitstops, HttpStatus.OK);
    }

    @GetMapping(value = "/pitstops/byName/{raceName}/{raceYear}/{driverFullName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PitStopDTO>> findByRaceNameAndRaceYearAndDriverFullName(@PathVariable() String raceName,
                                                                                       @PathVariable() int raceYear,
                                                                                       @PathVariable() String driverFullName,
                                                                                       @RequestParam(defaultValue = "0") Integer pageNo,
                                                                                       @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                       @RequestParam(required = false) String sortBy) {
        List<PitStopDTO> pitstops = null;
        String forename, surname;
        forename = driverFullName.split(" ")[0];
        surname = driverFullName.split(" ")[1];
        if(sortBy != null)
            pitstops = pitStopService.findByRaceNameAndRaceYearAndDriverFullName(raceName, raceYear, forename, surname, pageNo, pageSize, sortBy);
        else
            pitstops = pitStopService.findByRaceNameAndRaceYearAndDriverFullName(raceName, raceYear, forename, surname, pageNo, pageSize);

        return new ResponseEntity<>(pitstops, HttpStatus.OK);
    }

    @GetMapping(value = "/pitstops/byName/{raceName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PitStopDTO>> findByRaceName(@PathVariable() String raceName,
                                                           @RequestParam(defaultValue = "0") Integer pageNo,
                                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                                           @RequestParam(required = false) String sortBy) {
        List<PitStopDTO> pitstops = null;
        if(sortBy != null)
            pitstops = pitStopService.findByRaceName(raceName, pageNo, pageSize, sortBy);
        else
            pitstops = pitStopService.findByRaceName(raceName, pageNo, pageSize);

        return new ResponseEntity<>(pitstops, HttpStatus.OK);
    }

    @GetMapping(value = "/pitstops/byName/{raceName}/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PitStopDTO>> findByRaceNameAndYear( @PathVariable() String raceName,
                                                                   @PathVariable() int year,
                                                                   @RequestParam(defaultValue = "0") Integer pageNo,
                                                                   @RequestParam(defaultValue = "10") Integer pageSize,
                                                                   @RequestParam(required = false) String sortBy) {
        List<PitStopDTO> pitstops = null;
        if(sortBy != null)
            pitstops = pitStopService.findByRaceNameAndYear(raceName, year, pageNo, pageSize, sortBy);
        else
            pitstops = pitStopService.findByRaceNameAndYear(raceName, year, pageNo, pageSize);

        return new ResponseEntity<>(pitstops, HttpStatus.OK);
    }
}
