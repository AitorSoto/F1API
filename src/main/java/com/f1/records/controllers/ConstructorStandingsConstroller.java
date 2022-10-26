package com.f1.records.controllers;

import com.f1.records.pojos.DAOs.ConstructorStandingDAO;
import com.f1.records.services.constructorStandings.ConstructorStandingsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConstructorStandingsConstroller {
    @Autowired
    ConstructorStandingsServiceImpl constructorService;

    @GetMapping(value = "/constructorStandings")
    public ResponseEntity<List<ConstructorStandingDAO>> getConstructorResults() {
        return new ResponseEntity<>(constructorService.findAllConstructorStandings(), HttpStatus.OK);
    }

    @GetMapping(value = "/constructorStandingsById/{id}")
    public ResponseEntity<List<ConstructorStandingDAO>> getConstructorResultsById(@PathVariable int id) {
        return new ResponseEntity<>(constructorService.findConstructorStandingsById(id), HttpStatus.OK);
    }
}
