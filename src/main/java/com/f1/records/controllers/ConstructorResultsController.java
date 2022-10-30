package com.f1.records.controllers;

import com.f1.records.pojos.DAOs.ConstructorResultDAO;
import com.f1.records.pojos.DTOs.ConstructorResultDTO;
import com.f1.records.services.constructorResults.ConstructorResultsServiceImpl;
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
public class ConstructorResultsController {
    @Autowired
    ConstructorResultsServiceImpl constructorResultsService;

    @GetMapping(value = "/constructorResults", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ConstructorResultDTO>> getConstructorResults(@RequestParam(defaultValue = "0") int pageNo,
                                                                            @RequestParam(defaultValue = "10") int pageSize,
                                                                            @RequestParam(required = false) String sortBy) {
        if(sortBy == null)
            return new ResponseEntity<>(constructorResultsService.getAllConstructorResults(pageNo, pageSize), HttpStatus.OK);
        return new ResponseEntity<>(constructorResultsService.getAllConstructorResults(pageNo, pageSize, sortBy), HttpStatus.OK);
    }

    @GetMapping(value = "/constructorResults/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ConstructorResultDTO>> getConstructorResultsById(@RequestParam(defaultValue = "0") int pageNo,
                                                                                @RequestParam(defaultValue = "10") int pageSize,
                                                                                @RequestParam(required = false) String sortBy,
                                                                                @PathVariable int id) {
        if(sortBy == null)
            return new ResponseEntity<>(constructorResultsService.getAllConstructorResultsById(pageNo, pageSize, id), HttpStatus.OK);
        return new ResponseEntity<>(constructorResultsService.getAllConstructorResultsById(pageNo, pageSize, sortBy, id), HttpStatus.OK);
    }

    @GetMapping(value = "/constructorResults/{raceName}/{constructorName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ConstructorResultDTO>> getConstructorResultsByRaceNameAndConstructorName(@RequestParam(defaultValue = "0") int pageNo,
                                                                                                        @RequestParam(defaultValue = "10") int pageSize,
                                                                                                        @RequestParam(required = false) String sortBy,
                                                                                                        @PathVariable String raceName,
                                                                                                        @PathVariable String constructorName) {
        if(sortBy == null)
            return new ResponseEntity<>(constructorResultsService.getAllConstructorResultsByRaceNameAndConstructorName(pageNo, pageSize, raceName, constructorName), HttpStatus.OK);
        return new ResponseEntity<>(constructorResultsService.getAllConstructorResultsByRaceNameAndConstructorName(pageNo, pageSize, sortBy, raceName, constructorName), HttpStatus.OK);
    }

    @GetMapping(value = "/constructorResults/{raceName}/{raceYear}/{constructorName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConstructorResultDTO> getConstructorResultsByRaceNameAndConstructorNameAndRaceYear(@PathVariable String raceName,
                                                                                                             @PathVariable int raceYear,
                                                                                                             @PathVariable String constructorName) {
        return new ResponseEntity<>(constructorResultsService.getAllConstructorResultsByRaceNameAndConstructorNameAndRaceYear(raceName, constructorName, raceYear), HttpStatus.OK);
    }
}
