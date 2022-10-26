package com.f1.records.services.lapTime;

import com.f1.records.pojos.DAOs.LapTimeDAO;

import java.util.List;

public interface LapTimeService {
    List<LapTimeDAO> findAllLapTimes(int pageNo, int pageSize, String sortBy);
    List<LapTimeDAO> findAllLapTimes(int pageNo, int pageSize);
    List<LapTimeDAO> findByDriverIdAndRaceId(int driverId, int raceId, int pageNo, int pageSize, String sortBy);
    List<LapTimeDAO> findByDriverIdAndRaceId(int driverId, int raceId, int pageNo, int pageSize);
}
