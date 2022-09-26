package com.f1.records.services.lapTime;

import com.f1.records.pojos.LapTime;

import java.util.List;

public interface LapTimeService {
    List<LapTime> findAllLapTimes(int pageNo, int pageSize, String sortBy);
    List<LapTime> findAllLapTimes(int pageNo, int pageSize);
    List<LapTime> findByDriverIdAndRaceId(int driverId, int raceId, int pageNo, int pageSize, String sortBy);
    List<LapTime> findByDriverIdAndRaceId(int driverId, int raceId, int pageNo, int pageSize);
}
