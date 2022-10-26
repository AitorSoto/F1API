package com.f1.records.services.qualifying;

import com.f1.records.pojos.DAOs.QualifyingDAO;

import java.util.List;

public interface QualifyingService {
    List<QualifyingDAO> getAllQualys(int pageNo, int pageSize);
    List<QualifyingDAO> getAllQualys(int pageNo, int pageSize, String sortBy);
    QualifyingDAO getQualyByRaceIdAndDriverId(int raceId, int driverId);
    List<QualifyingDAO> getAllQualysByRaceId(int raceId, int pageNo, int pageSize);
    List<QualifyingDAO> getAllQualysByRaceId(int raceId, int pageNo, int pageSize, String sortBy);
    List<QualifyingDAO> getAllQualysByRaceIdAndConstructorId(int raceId, int constructorId);
}
