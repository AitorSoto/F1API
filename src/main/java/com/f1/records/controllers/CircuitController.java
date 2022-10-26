package com.f1.records.controllers;

import com.f1.records.pojos.DAOs.CircuitDAO;
import com.f1.records.services.circuit.CircuitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CircuitController {
    @Autowired
    CircuitServiceImpl circuitService;

    @GetMapping(value = "/circuits")
    public ResponseEntity<List<CircuitDAO>> getAllCircuits(@PathVariable() int pageNo,
                                                           @PathVariable() int pageSize,
                                                           @PathVariable(required = false) String sortBy) {
        //Pageable
        if(sortBy != null)
        {

        }
        return new ResponseEntity<>(circuitService.getAllCircuits(10, 0), HttpStatus.OK);
    }

    @GetMapping(value = "/circuit/{id}")
    public ResponseEntity<CircuitDAO> getCircuitById(@PathVariable int id) {
        return new ResponseEntity<>(circuitService.getCircuitById(id), HttpStatus.OK);
    }
}
