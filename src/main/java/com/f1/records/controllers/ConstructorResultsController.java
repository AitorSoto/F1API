package com.f1.records.controllers;

import com.f1.records.pojos.DAOs.ConstructorResultDAO;
import com.f1.records.services.constructorResults.ConstructorResultsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConstructorResultsController {
    @Autowired
    ConstructorResultsServiceImpl constructorResultsService;

    @GetMapping(value = "/constructorResults", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ConstructorResultDAO>> getConstructorResults() {
        return new ResponseEntity<>(constructorResultsService.getAllConstructorResults(), HttpStatus.OK);
    }

    @GetMapping(value = "/constructorResults/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ConstructorResultDAO>> getConstructorResultsById(@PathVariable int id) {
        return new ResponseEntity<>(constructorResultsService.getAllConstructorResultsById(id), HttpStatus.OK);
    }
}
