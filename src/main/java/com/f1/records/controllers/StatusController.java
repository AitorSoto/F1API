package com.f1.records.controllers;

import com.f1.records.pojos.DTOs.Status;
import com.f1.records.services.status.StatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatusController {

    @Autowired
    StatusServiceImpl statusService;

    @GetMapping(value = "/statuses")
    public ResponseEntity<List<Status>> getStatuses() {
        return new ResponseEntity<>(statusService.getAllStatuses(), HttpStatus.OK);
    }

    @GetMapping(value = "/status/{id}")
    public ResponseEntity<Status> getStatusById(@PathVariable int id) {
        return new ResponseEntity<>(statusService.getById(id), HttpStatus.OK);
    }
}
