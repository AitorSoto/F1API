package com.f1.records.services.qualifying;

import com.f1.records.pojos.DAOs.QualifyingDAO;
import com.f1.records.pojos.DTOs.QualifyingDTO;

import java.util.List;

public interface QualifyingService {
    List<QualifyingDTO> getAllQualys(int pageNo, int pageSize);
    List<QualifyingDTO> getAllQualys(int pageNo, int pageSize, String sortBy);
    QualifyingDTO getQualyByRaceIdAndDriverId(int raceId, int driverId);
    List<QualifyingDTO> getAllQualysByRaceId(int raceId, int pageNo, int pageSize);
    List<QualifyingDTO> getAllQualysByRaceId(int raceId, int pageNo, int pageSize, String sortBy);
    List<QualifyingDTO> getAllQualysByRaceIdAndConstructorId(int raceId, int constructorId);
}
