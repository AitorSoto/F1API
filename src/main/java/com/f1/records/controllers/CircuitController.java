package com.f1.records.controllers;

import com.f1.records.pojos.Circuit;
import com.f1.records.services.CircuitServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CircuitController {
    @Autowired
    CircuitServiceImpl circuitService;

    @RequestMapping(value = "/circuits")
    public ResponseEntity<List<Circuit>> getAllCircuits() {
        return new ResponseEntity<>(circuitService.getAllCircuits(), HttpStatus.OK);
    }

    @RequestMapping(value = "/circuit/{id}")
    public ResponseEntity<Circuit> getCircuitById(@PathVariable int id) {
        return new ResponseEntity<>(circuitService.getCircuitById(id), HttpStatus.OK);
    }
}
