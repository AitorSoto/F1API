package com.f1.records.controllers;

import com.f1.records.pojos.ConstructorResults;
import com.f1.records.services.constructorResults.ConstructorResultsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConstructorResultsController {
    @Autowired
    ConstructorResultsServiceImpl constructorResultsService;

    @GetMapping(value = "/constructorResults")
    public ResponseEntity<List<ConstructorResults>> getConstructorResults() {
        return new ResponseEntity<>(constructorResultsService.getAllConstructorResults(), HttpStatus.OK);
    }

    @GetMapping(value = "/constructorResults/{id}")
    public ResponseEntity<List<ConstructorResults>> getConstructorResultsById(@PathVariable int id) {
        return new ResponseEntity<>(constructorResultsService.getAllConstructorResultsById(id), HttpStatus.OK);
    }
}
