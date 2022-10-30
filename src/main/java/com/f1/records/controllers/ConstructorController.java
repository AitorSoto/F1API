package com.f1.records.controllers;

import com.f1.records.pojos.DTOs.ConstructorDTO;
import com.f1.records.services.constructors.ConstructorServiceImpl;
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
public class ConstructorController {
    @Autowired
    ConstructorServiceImpl constructorService;

    @GetMapping(value = "/constructors", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ConstructorDTO>> getConstructorResults(@RequestParam(defaultValue = "0") int pageNo,
                                                                      @RequestParam(defaultValue = "10") int pageSize,
                                                                      @RequestParam(required = false) String sortBy) {
        if(sortBy == null)
            return new ResponseEntity<>(constructorService.findAllConstructors(pageNo, pageSize), HttpStatus.OK);
        return new ResponseEntity<>(constructorService.findAllConstructors(pageNo, pageSize, sortBy), HttpStatus.OK);
    }

    @GetMapping(value = "/constructor/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConstructorDTO> getConstructorById(@PathVariable int id) {
        return new ResponseEntity<>(constructorService.findConstructorById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/constructor/name/{constructorName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ConstructorDTO> getConstructorByName(@PathVariable String constructorName) {
        return new ResponseEntity<>(constructorService.findConstructorByName(constructorName), HttpStatus.OK);
    }
}
