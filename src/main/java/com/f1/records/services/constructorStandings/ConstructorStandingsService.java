package com.f1.records.services.constructorStandings;

import com.f1.records.pojos.ConstructorStandings;

import java.util.List;

public interface ConstructorStandingsService {
    List<ConstructorStandings> findAllConstructorStandings();
    List<ConstructorStandings> findConstructorStandingsById(int id);
}
