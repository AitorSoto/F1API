package com.f1.records.controllers;

import com.f1.records.pojos.DAOs.PitStopDAO;
import com.f1.records.services.pitStopService.PitStopServiceImpl;
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
public class PitStopController {
    @Autowired
    PitStopServiceImpl pitStopService;

    @GetMapping(value = "/pitstops", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PitStopDAO>> findAllPitStops(@RequestParam(defaultValue = "0") Integer pageNo,
                                                            @RequestParam(defaultValue = "10") Integer pageSize,
                                                            @RequestParam(required = false) String sortBy) {
        List<PitStopDAO> lapTimes = null;
        if(sortBy != null)
            lapTimes = pitStopService.findAllPitStops(pageNo, pageSize, sortBy);
        else
            lapTimes = pitStopService.findAllPitStops(pageNo, pageSize);

        return new ResponseEntity<>(lapTimes, HttpStatus.OK);
    }

    @GetMapping(value = "/pitstops/{driverId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PitStopDAO>> findAllPitStopsByDriverId(@PathVariable() int driverId,
                                                                      @RequestParam(defaultValue = "0") Integer pageNo,
                                                                      @RequestParam(defaultValue = "10") Integer pageSize,
                                                                      @RequestParam(required = false) String sortBy) {
        List<PitStopDAO> lapTimes = null;
        if(sortBy != null)
            lapTimes = pitStopService.findByDriverId(driverId, pageNo, pageSize, sortBy);
        else
            lapTimes = pitStopService.findByDriverId(driverId, pageNo, pageSize);

        return new ResponseEntity<>(lapTimes, HttpStatus.OK);
    }

    @GetMapping(value = "/pitstops/{driverId}/{raceId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PitStopDAO>> findAllPitStopsByDriverIdAndRaceId(@PathVariable() int driverId,
                                                                               @PathVariable() int raceId,
                                                                               @RequestParam(defaultValue = "0") Integer pageNo,
                                                                               @RequestParam(defaultValue = "10") Integer pageSize,
                                                                               @RequestParam(required = false) String sortBy) {
        List<PitStopDAO> lapTimes = null;
        if(sortBy != null)
            lapTimes = pitStopService.findByDriverIdAndRaceId(driverId, raceId,pageNo, pageSize, sortBy);
        else
            lapTimes = pitStopService.findByDriverIdAndRaceId(driverId, raceId,pageNo, pageSize);

        return new ResponseEntity<>(lapTimes, HttpStatus.OK);
    }
}
