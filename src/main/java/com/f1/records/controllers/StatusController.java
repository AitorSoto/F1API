package com.f1.records.controllers;

import com.f1.records.pojos.DTOs.StatusDTO;
import com.f1.records.pojos.DTOs.StatusDTO;
import com.f1.records.services.status.StatusServiceImpl;
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
public class StatusController {

    @Autowired
    StatusServiceImpl statusService;

    @GetMapping(value = "/statuses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<StatusDTO>> getStatuses(@RequestParam(defaultValue = "0") int pageNo,
                                                       @RequestParam(defaultValue = "10") int pageSize) {
        return new ResponseEntity<>(statusService.getAllStatuses(pageNo, pageSize), HttpStatus.OK);
    }

    @GetMapping(value = "/status/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StatusDTO> getStatusById(@PathVariable int id) {
        return new ResponseEntity<>(statusService.getById(id), HttpStatus.OK);
    }
}
