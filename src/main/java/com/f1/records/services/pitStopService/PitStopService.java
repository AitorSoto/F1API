package com.f1.records.services.pitStopService;

import com.f1.records.pojos.DTOs.PitStopDTO;

import java.util.List;

public interface PitStopService {
    List<PitStopDTO> findAllPitStops(int pageNo, int pageSize);
    List<PitStopDTO> findAllPitStops(int pageNo, int pageSize, String sortBy);
    List<PitStopDTO> findByDriverId(int driverId, int pageNo, int pageSize);
    List<PitStopDTO> findByDriverId(int driverId, int pageNo, int pageSize, String sortBy);
    List<PitStopDTO> findByDriverIdAndRaceId(int driverId, int raceId, int pageNo, int pageSize);
    List<PitStopDTO> findByDriverIdAndRaceId(int driverId, int raceId, int pageNo, int pageSize, String sortBy);
    List<PitStopDTO> findByRaceNameAndYear(String raceName, int year, int pageNo, int pageSize);
    List<PitStopDTO> findByRaceNameAndYear(String raceName, int year, int pageNo, int pageSize, String sortBy);
    List<PitStopDTO> findByRaceName(String raceName, int pageNo, int pageSize);
    List<PitStopDTO> findByRaceName(String raceName, int pageNo, int pageSize, String sortBy);
    List<PitStopDTO> findByRaceNameAndRaceYearAndDriverFullName(String raceName, int year, String driverForename, String driverSurname, int pageNo, int pageSize);
    List<PitStopDTO> findByRaceNameAndRaceYearAndDriverFullName(String raceName, int year, String driverForename, String driverSurname, int pageNo, int pageSize, String sortBy);
}
