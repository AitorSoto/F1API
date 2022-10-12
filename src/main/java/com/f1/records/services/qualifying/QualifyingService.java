package com.f1.records.services.qualifying;

import com.f1.records.pojos.DTOs.Qualifying;

import java.util.List;

public interface QualifyingService {
    List<Qualifying> getAllQualys(int pageNo, int pageSize);
    List<Qualifying> getAllQualys(int pageNo, int pageSize, String sortBy);
    Qualifying getQualyByRaceIdAndDriverId(int raceId, int driverId);
    List<Qualifying> getAllQualysByRaceId(int raceId, int pageNo, int pageSize);
    List<Qualifying> getAllQualysByRaceId(int raceId, int pageNo, int pageSize, String sortBy);
    List<Qualifying> getAllQualysByRaceIdAndConstructorId(int raceId, int constructorId);
}
