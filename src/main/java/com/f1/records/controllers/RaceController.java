package com.f1.records.controllers;

import com.f1.records.pojos.DTOs.RaceDTO;
import com.f1.records.services.race.RaceServiceImpl;
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
public class RaceController {
    @Autowired
    RaceServiceImpl raceService;

    @GetMapping(value = "/races", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RaceDTO>> getAllRaces(@RequestParam(defaultValue = "0") Integer pageNo,
                                                     @RequestParam(defaultValue = "10") Integer pageSize,
                                                     @RequestParam(required = false) String sortBy) {
        if(sortBy == null)
            return new ResponseEntity<>(raceService.getAllRaces(pageNo, pageSize), HttpStatus.OK);
        return new ResponseEntity<>(raceService.getAllRaces(pageNo, pageSize, sortBy), HttpStatus.OK);
    }

    @GetMapping(value = "/races/year/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RaceDTO>> getRacesByYear(@RequestParam(defaultValue = "0") Integer pageNo,
                                                        @RequestParam(defaultValue = "10") Integer pageSize,
                                                        @RequestParam(required = false) String sortBy,
                                                        @PathVariable int year) {
        if(sortBy == null)
            return new ResponseEntity<>(raceService.getRacesByYear(pageNo, pageSize, year), HttpStatus.OK);
        return new ResponseEntity<>(raceService.getRacesByYear(pageNo, pageSize, sortBy, year), HttpStatus.OK);
    }

    @GetMapping(value = "/races/round/{round}/{year}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RaceDTO> getRacesByRoundAndYear(@PathVariable int round,
                                                          @PathVariable int year) {
        return new ResponseEntity<>(raceService.getRacesByRoundAndYear(round, year), HttpStatus.OK);
    }

    @GetMapping(value = "/races/country/{country}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RaceDTO>> getRacesByCountry(@RequestParam(defaultValue = "0") Integer pageNo,
                                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                                           @RequestParam(required = false) String sortBy,
                                                           @PathVariable String country) {
        if(sortBy == null)
            return new ResponseEntity<>(raceService.getRacesByCountry(pageNo, pageSize, country), HttpStatus.OK);
        return new ResponseEntity<>(raceService.getRacesByCountry(pageNo, pageSize, sortBy, country), HttpStatus.OK);
    }

    @GetMapping(value = "/races/circuit/{circuit}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RaceDTO>> getRacesByCircuit(@RequestParam(defaultValue = "0") Integer pageNo,
                                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                                           @RequestParam(required = false) String sortBy,
                                                           @PathVariable String circuit) {
        if(sortBy == null)
            return new ResponseEntity<>(raceService.getRacesByCircuit(pageNo, pageSize, circuit), HttpStatus.OK);
        return new ResponseEntity<>(raceService.getRacesByCircuit(pageNo, pageSize, sortBy, circuit), HttpStatus.OK);
    }
}
