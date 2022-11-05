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
    List<QualifyingDTO> getAllQualysByRaceIdAndConstructorId(int pageNo, int pageSize, int raceId, int constructorId);
    List<QualifyingDTO> getAllQualysByRaceIdAndConstructorId(int pageNo, int pageSize, String sortBy, int raceId, int constructorId);
    List<QualifyingDTO> getQualifyingByRaceNameAndConstructorName(int pageNo, int pageSize, String raceName, String constructorName);
    List<QualifyingDTO> getQualifyingByRaceNameAndConstructorName(int pageNo, int pageSize, String sortBy, String raceName, String constructorName);
    List<QualifyingDTO> getQualifyingByRaceNameAndDriverFullName(int pageNo, int pageSize, String raceName, String driverSurname, String driverForename);
    List<QualifyingDTO> getQualifyingByRaceNameAndDriverFullName(int pageNo, int pageSize, String sortBy, String raceName, String driverSurname, String driverForename);
    List<QualifyingDTO> getQualifyingByRaceNameAndRaceYear(int pageNo, int pageSize, String raceName, int year);
    List<QualifyingDTO> getQualifyingByRaceNameAndRaceYear(int pageNo, int pageSize, String sortBy, String raceName, int year);
    QualifyingDTO getQualifyingByRaceNameAndRaceYearAndDriverFullName(String raceName, int year, String driverForename, String driverSurname);
}
