package com.f1.records.controllers;

import com.f1.records.pojos.Status;
import com.f1.records.services.StatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StatusController {

    @Autowired
    StatusServiceImpl statusService;

    @RequestMapping(value = "/statuses")
    public ResponseEntity<List<Status>> getStatuses() {
        return new ResponseEntity<>(statusService.getAllStatuses(), HttpStatus.OK);
    }

    @RequestMapping(value = "/status/{id}")
    public ResponseEntity<Status> getStatusById(@PathVariable int id) {
        return new ResponseEntity<>(statusService.getById(id), HttpStatus.OK);
    }
}
