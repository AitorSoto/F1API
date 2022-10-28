package com.f1.records.services.constructorStandings;


import com.f1.records.pojos.DAOs.ConstructorStandingDAO;

import java.util.List;

public interface ConstructorStandingsService {
    List<ConstructorStandingDAO> findAllConstructorStandings();
    List<ConstructorStandingDAO> findConstructorStandingsById(int id);
}
