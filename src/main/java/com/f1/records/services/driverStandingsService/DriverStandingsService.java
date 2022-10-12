package com.f1.records.services.driverStandingsService;

import com.f1.records.pojos.DTOs.DriverStanding;

import java.util.List;

public interface DriverStandingsService {
    List<DriverStanding> findAllDriverStandings(int pageNo, int pageSize);
    List<DriverStanding> findAllDriverStandings(int pageNo, int pageSize, String sortBy);
    List<DriverStanding> findDriverStandingsByDriverId(int pageNo, int pageSize, int driverId);
    List<DriverStanding> findDriverStandingsByDriverId(int pageNo, int pageSize, String sortBy,int driverId);
    DriverStanding findDriverStandingsByDriverIdAndRaceId(int pageNo, int pageSize, int driverId, int raceId);
    DriverStanding findDriverStandingsByDriverIdAndRaceId(int pageNo, int pageSize, String sortBy, int driverId, int raceId);
}
