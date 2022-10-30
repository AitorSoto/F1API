package com.f1.records.controllers;

import com.f1.records.pojos.DAOs.ConstructorStandingDAO;
import com.f1.records.pojos.DTOs.ConstructorStandingDTO;
import com.f1.records.services.constructorStandings.ConstructorStandingsServiceImpl;
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
public class ConstructorStandingsConstroller {
    @Autowired
    ConstructorStandingsServiceImpl constructorService;

    @GetMapping(value = "/constructorStandings", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ConstructorStandingDTO>> getConstructorResults(@RequestParam(defaultValue = "0") Integer pageNo,
                                                                              @RequestParam(defaultValue = "10") Integer pageSize,
                                                                              @RequestParam(required = false) String sortBy) {
        if(sortBy == null)
            return new ResponseEntity<>(constructorService.findAllConstructorStandings(pageNo, pageSize), HttpStatus.OK);
        return new ResponseEntity<>(constructorService.findAllConstructorStandings(pageNo, pageSize, sortBy), HttpStatus.OK);
    }

    @GetMapping(value = "/constructorStandingsById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ConstructorStandingDTO>> getConstructorResultsById(@PathVariable int id,
                                                                                  @RequestParam(defaultValue = "0") Integer pageNo,
                                                                                  @RequestParam(defaultValue = "10") Integer pageSize,
                                                                                  @RequestParam(required = false) String sortBy) {
        if(sortBy == null)
            return new ResponseEntity<>(constructorService.findConstructorStandingsById(pageNo, pageSize, id), HttpStatus.OK);
        return new ResponseEntity<>(constructorService.findConstructorStandingsById(pageNo, pageSize, sortBy, id), HttpStatus.OK);
    }

    @GetMapping(value = "/constructorStandingsById/{raceName}/{raceYear}/{constructorName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConstructorStandingDTO> getConstructorResultsByRaceNameAndRaceYearAndConstructorName( @PathVariable String raceName,
                                                                                                                @PathVariable int raceYear,
                                                                                                                @PathVariable String constructorName) {
        return new ResponseEntity<>(constructorService.findConstructorStandingDTOByRaceNameAndRaceYearAndConstructorName(raceName, raceYear, constructorName), HttpStatus.OK);
    }
}
