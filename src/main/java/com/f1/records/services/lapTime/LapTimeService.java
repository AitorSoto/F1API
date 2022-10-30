package com.f1.records.services.lapTime;

import com.f1.records.pojos.DTOs.LapTimeDTO;

import java.util.List;

public interface LapTimeService {
    List<LapTimeDTO> findAllLapTimes(int pageNo, int pageSize, String sortBy);
    List<LapTimeDTO> findAllLapTimes(int pageNo, int pageSize);
    List<LapTimeDTO> findByDriverIdAndRaceId(int driverId, int raceId, int pageNo, int pageSize, String sortBy);
    List<LapTimeDTO> findByDriverIdAndRaceId(int driverId, int raceId, int pageNo, int pageSize);
}
