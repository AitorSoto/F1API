package com.f1.records.services.result;

import com.f1.records.pojos.DTOs.Result;

import java.util.List;

public interface ResultService {
    List<Result> getAllResults(int pageNo, int pageSize);
    List<Result> getAllResults(int pageNo, int pageSize, String sortBy);
    List<Result> getResultsByRaceYearAndRaceName(int pageNo, int pageSize, int raceYear, String circuitName);
    List<Result> getResultsByRaceYearAndRaceName(int pageNo, int pageSize, String sortBy,int raceYear, String circuitName);
    Result getResultsByRaceYearAndCircuitNameAndDriverSurname(int raceYear, String circuitName, String driverName, String driverSurname);
}
