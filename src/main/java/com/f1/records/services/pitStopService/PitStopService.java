package com.f1.records.services.pitStopService;

import com.f1.records.pojos.DTOs.PitStop;

import java.util.List;

public interface PitStopService {
    List<PitStop> findAllPitStops(int pageNo, int pageSize);
    List<PitStop> findAllPitStops(int pageNo, int pageSize, String sortBy);
    List<PitStop> findByDriverId(int driverId, int pageNo, int pageSize);
    List<PitStop> findByDriverId(int driverId, int pageNo, int pageSize, String sortBy);
    List<PitStop> findByDriverIdAndRaceId(int driverId, int raceId, int pageNo, int pageSize);
    List<PitStop> findByDriverIdAndRaceId(int driverId, int raceId, int pageNo, int pageSize, String sortBy);
}
