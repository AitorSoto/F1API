package com.f1.records.services.driverStandingsService;

import com.f1.records.pojos.DAOs.DriverStandingDAO;

import java.util.List;

public interface DriverStandingsService {
    List<DriverStandingDAO> findAllDriverStandings(int pageNo, int pageSize);
    List<DriverStandingDAO> findAllDriverStandings(int pageNo, int pageSize, String sortBy);
    List<DriverStandingDAO> findDriverStandingsByDriverId(int pageNo, int pageSize, int driverId);
    List<DriverStandingDAO> findDriverStandingsByDriverId(int pageNo, int pageSize, String sortBy, int driverId);
    DriverStandingDAO findDriverStandingsByDriverIdAndRaceId(int pageNo, int pageSize, int driverId, int raceId);
    DriverStandingDAO findDriverStandingsByDriverIdAndRaceId(int pageNo, int pageSize, String sortBy, int driverId, int raceId);
}
