package com.f1.records.services.constructorStandings;

import com.f1.records.pojos.DTOs.ConstructorStanding;

import java.util.List;

public interface ConstructorStandingsService {
    List<ConstructorStanding> findAllConstructorStandings();
    List<ConstructorStanding> findConstructorStandingsById(int id);
}
