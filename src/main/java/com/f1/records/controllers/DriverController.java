package com.f1.records.controllers;

import com.f1.records.pojos.DTOs.DriverDTO;
import com.f1.records.pojos.pagination.PaginationInfo;
import com.f1.records.pojos.pagination.Wrapper;
import com.f1.records.services.driver.DriverServiceImpl;
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
public class DriverController {
    @Autowired
    DriverServiceImpl driverService;

    @GetMapping(value = "/drivers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Wrapper<DriverDTO>> findAllDrivers(@RequestParam(defaultValue = "0") Integer pageNo,
                                                          @RequestParam(defaultValue = "10") Integer pageSize,
                                                          @RequestParam(required = false) String sortBy) {
        List<DriverDTO> driverDTOs = null;
        Wrapper<DriverDTO> driverDTOWrapper = new Wrapper<>();
        if(sortBy != null)
            driverDTOs = driverService.findAllDrivers(pageNo, pageSize, sortBy);
        else
            driverDTOs = driverService.findAllDrivers(pageNo, pageSize);

        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setCurrentPage(pageNo);
        paginationInfo.setHasNext(pageNo < (driverService.getNumberOfDrivers()) / pageSize);

        driverDTOWrapper.setDto(driverDTOs);
        driverDTOWrapper.setPaginationInfo(paginationInfo);

        return new ResponseEntity<>(driverDTOWrapper, HttpStatus.OK);
    }

    @GetMapping(value = "/drivers/{completeName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DriverDTO> findDriverBySurname(@PathVariable String completeName) {
        if(completeName.split(" ").length < 2){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        String surname, forename;
        forename = completeName.split(" ")[0];
        surname = completeName.split(" ")[1];
        DriverDTO driverDTO = driverService.findDriverBySurname(forename, surname);
        return new ResponseEntity<>(driverDTO, HttpStatus.OK);
    }
}
