package com.f1.records.controllers;

import com.f1.records.pojos.DAOs.LapTimeDAO;
import com.f1.records.services.lapTime.LapTimeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LapTimeController {
    @Autowired
    LapTimeServiceImpl lapTimeService;

    @GetMapping(value = "/laptimes")
    public ResponseEntity<List<LapTimeDAO>> findAllLaptimes(@RequestParam(defaultValue = "0") Integer pageNo,
                                                            @RequestParam(defaultValue = "10") Integer pageSize,
                                                            @RequestParam(required = false) String sortBy) {
        List<LapTimeDAO> lapTimeDAOS = null;
        if(sortBy != null)
            lapTimeDAOS = lapTimeService.findAllLapTimes(pageNo, pageSize, sortBy);
        else
            lapTimeDAOS = lapTimeService.findAllLapTimes(pageNo, pageSize);

        return new ResponseEntity<>(lapTimeDAOS, HttpStatus.OK);
    }

    @GetMapping(value = "/laptimesById/{driverId}/{raceId}")
    public ResponseEntity<List<LapTimeDAO>> findByDriverIdAndRaceId(@PathVariable() int driverId,
                                                                    @PathVariable() int raceId,
                                                                    @RequestParam(defaultValue = "0") Integer pageNo,
                                                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                                                    @RequestParam(required = false) String sortBy) {
        List<LapTimeDAO> lapTimeDAOS = null;
        if(sortBy != null)
            lapTimeDAOS = lapTimeService.findByDriverIdAndRaceId(driverId, raceId, pageNo, pageSize, sortBy);
        else
            lapTimeDAOS = lapTimeService.findByDriverIdAndRaceId(driverId, raceId, pageNo, pageSize);

        return new ResponseEntity<>(lapTimeDAOS, HttpStatus.OK);
    }
}
