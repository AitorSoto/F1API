package com.f1.records.controllers;

import com.f1.records.pojos.DAOs.CircuitDAO;
import com.f1.records.pojos.DTOs.CircuitDTO;
import com.f1.records.services.circuit.CircuitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CircuitController {
    @Autowired
    CircuitServiceImpl circuitService;

    @GetMapping(value = "/circuits", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CircuitDTO>> getAllCircuits(@PathVariable(value = "10") int pageNo,
                                                           @PathVariable(value = "0") int pageSize,
                                                           @PathVariable(required = false) String sortBy) {
        if(sortBy == null)
            return new ResponseEntity<>(circuitService.getAllCircuits(pageNo, pageSize), HttpStatus.OK);
        return new ResponseEntity<>(circuitService.getAllCircuits(pageNo, pageSize, sortBy), HttpStatus.OK);
    }

    @GetMapping(value = "/circuit/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CircuitDTO> getCircuitById(@PathVariable int id) {
        return new ResponseEntity<>(circuitService.getCircuitById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/circuit/countryName/{country}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CircuitDTO>> getCircuitById(@PathVariable String country) {
        return new ResponseEntity<>(circuitService.getCircuitByCountry(country), HttpStatus.OK);
    }
}
