package com.f1.records.services.driverStandingsService;

import com.f1.records.pojos.DAOs.DriverStandingDAO;
import com.f1.records.pojos.DTOs.DriverStandingDTO;

import java.util.List;

public interface DriverStandingsService {
    List<DriverStandingDTO> findAllDriverStandings(int pageNo, int pageSize);
    List<DriverStandingDTO> findAllDriverStandings(int pageNo, int pageSize, String sortBy);
    List<DriverStandingDTO> findDriverStandingsByDriverId(int pageNo, int pageSize, int driverId);
    List<DriverStandingDTO> findDriverStandingsByDriverId(int pageNo, int pageSize, String sortBy, int driverId);
    DriverStandingDTO findDriverStandingsByDriverIdAndRaceId(int driverId, int raceId);
}
