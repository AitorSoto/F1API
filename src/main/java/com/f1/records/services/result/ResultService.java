package com.f1.records.services.result;

import com.f1.records.pojos.DTOs.ResultDTO;

import java.util.List;

public interface ResultService {
    List<ResultDTO> getAllResults(int pageNo, int pageSize);
    List<ResultDTO> getAllResults(int pageNo, int pageSize, String sortBy);
    List<ResultDTO> getResultsByRaceYearAndRaceName(int pageNo, int pageSize, int raceYear, String circuitName);
    List<ResultDTO> getResultsByRaceYearAndRaceName(int pageNo, int pageSize, String sortBy, int raceYear, String circuitName);
    ResultDTO getResultsByRaceYearAndCircuitNameAndDriverSurname(int raceYear, String circuitName, String driverName, String driverSurname);
}
