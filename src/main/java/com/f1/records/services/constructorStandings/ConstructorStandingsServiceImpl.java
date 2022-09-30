package com.f1.records.services.constructorStandings;

import com.f1.records.pojos.ConstructorStanding;
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
    public List<ConstructorStanding> findAllConstructorStandings() {
        Iterable<ConstructorStanding> constructorStandings = constructorsStandingsRepository.findAll();
        List<ConstructorStanding> constructorStandingList = new ArrayList<>();
        constructorStandings.forEach(constructorStandingList::add);
        return constructorStandingList;
    }

    @Override
    public List<ConstructorStanding> findConstructorStandingsById(int id) {
        Iterable<ConstructorStanding> constructorStandings = constructorsStandingsRepository.findAll();
        List<ConstructorStanding> constructorStandingList = new ArrayList<>();
        constructorStandings.forEach(constructorStandingList::add);
        List<ConstructorStanding> constructorFiltered =
                constructorStandingList.stream()
                .filter(constructor -> constructor.getConstructorId() == id)
                .collect(Collectors.toList());
        return constructorFiltered;
    }
}
