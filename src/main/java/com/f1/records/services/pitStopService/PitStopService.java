package com.f1.records.services.pitStopService;

import com.f1.records.pojos.DAOs.PitStopDAO;

import java.util.List;

public interface PitStopService {
    List<PitStopDAO> findAllPitStops(int pageNo, int pageSize);
    List<PitStopDAO> findAllPitStops(int pageNo, int pageSize, String sortBy);
    List<PitStopDAO> findByDriverId(int driverId, int pageNo, int pageSize);
    List<PitStopDAO> findByDriverId(int driverId, int pageNo, int pageSize, String sortBy);
    List<PitStopDAO> findByDriverIdAndRaceId(int driverId, int raceId, int pageNo, int pageSize);
    List<PitStopDAO> findByDriverIdAndRaceId(int driverId, int raceId, int pageNo, int pageSize, String sortBy);
}
