package com.f1.records.services.constructorStandings;

import com.f1.records.pojos.Constructor;
import com.f1.records.pojos.ConstructorStandings;
import com.f1.records.repositorys.ConstructorsStandingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConstructorStandingsServiceImpl implements ConstructorStandingsService {
    @Autowired
    ConstructorsStandingsRepository constructorsStandingsRepository;

    @Override
    public List<ConstructorStandings> findAllConstructorStandings() {
        Iterable<ConstructorStandings> constructorStandings = constructorsStandingsRepository.findAll();
        List<ConstructorStandings> constructorStandingsList = new ArrayList<>();
        constructorStandings.forEach(constructorStandingsList::add);
        return constructorStandingsList;
    }

    @Override
    public List<ConstructorStandings> findConstructorStandingsById(int id) {
        Iterable<ConstructorStandings> constructorStandings = constructorsStandingsRepository.findAll();
        List<ConstructorStandings> constructorStandingsList = new ArrayList<>();
        constructorStandings.forEach(constructorStandingsList::add);
        List<ConstructorStandings> constructorFiltered =
                constructorStandingsList.stream()
                .filter(constructor -> constructor.getConstructorId() == id)
                .collect(Collectors.toList());
        return constructorFiltered;
    }
}
