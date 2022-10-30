package com.f1.records.services.constructorStandings;


import com.f1.records.pojos.DTOs.ConstructorStandingDTO;

import java.util.List;

public interface ConstructorStandingsService {
    List<ConstructorStandingDTO> findAllConstructorStandings(int pageNo, int pageSize);
    List<ConstructorStandingDTO> findAllConstructorStandings(int pageNo, int pageSize, String sortBy);
    List<ConstructorStandingDTO> findConstructorStandingsById(int pageNo, int pageSize, int id);
    List<ConstructorStandingDTO> findConstructorStandingsById(int pageNo, int pageSize, String sortBy, int id);
    ConstructorStandingDTO findConstructorStandingDTOByRaceNameAndRaceYearAndConstructorName(String raceName, int raceYear, String constructorName);
}
