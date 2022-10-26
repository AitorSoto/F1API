package com.f1.records.services.result;

import com.f1.records.pojos.DAOs.ResultDAO;

import java.util.List;

public interface ResultService {
    List<ResultDAO> getAllResults(int pageNo, int pageSize);
    List<ResultDAO> getAllResults(int pageNo, int pageSize, String sortBy);
    List<ResultDAO> getResultsByRaceYearAndRaceName(int pageNo, int pageSize, int raceYear, String circuitName);
    List<ResultDAO> getResultsByRaceYearAndRaceName(int pageNo, int pageSize, String sortBy, int raceYear, String circuitName);
    ResultDAO getResultsByRaceYearAndCircuitNameAndDriverSurname(int raceYear, String circuitName, String driverName, String driverSurname);
}
