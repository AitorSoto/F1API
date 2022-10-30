package com.f1.records.services.constructorResults;

import com.f1.records.pojos.DTOs.ConstructorResultDTO;

import java.util.List;

public interface ConstructorResultsService {
    List<ConstructorResultDTO> getAllConstructorResults(int pageNo, int pageSize);
    List<ConstructorResultDTO> getAllConstructorResults(int pageNo, int pageSize, String sortBy);
    List<ConstructorResultDTO> getAllConstructorResultsById(int pageNo, int pageSize, int idConstructor);
    List<ConstructorResultDTO> getAllConstructorResultsById(int pageNo, int pageSize, String sortBy, int idConstructor);
    List<ConstructorResultDTO> getAllConstructorResultsByRaceNameAndConstructorName(int pageNo, int pageSize, String raceName, String constructorName);
    List<ConstructorResultDTO> getAllConstructorResultsByRaceNameAndConstructorName(int pageNo, int pageSize, String sortBy,String raceName, String constructorName);
    ConstructorResultDTO getAllConstructorResultsByRaceNameAndConstructorNameAndRaceYear(String raceName, String constructorName, int raceYear);
}
