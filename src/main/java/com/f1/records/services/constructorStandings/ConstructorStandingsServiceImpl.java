package com.f1.records.services.constructorStandings;

import com.f1.records.pojos.DAOs.ConstructorStandingDAO;
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
    public List<ConstructorStandingDAO> findAllConstructorStandings() {
        Iterable<ConstructorStandingDAO> constructorStandings = constructorsStandingsRepository.findAll();
        List<ConstructorStandingDAO> constructorStandingDAOList = new ArrayList<>();
        constructorStandings.forEach(constructorStandingDAOList::add);
        return constructorStandingDAOList;
    }

    @Override
    public List<ConstructorStandingDAO> findConstructorStandingsById(int id) {
        Iterable<ConstructorStandingDAO> constructorStandings = constructorsStandingsRepository.findAll();
        List<ConstructorStandingDAO> constructorStandingDAOList = new ArrayList<>();
        constructorStandings.forEach(constructorStandingDAOList::add);
        List<ConstructorStandingDAO> constructorFiltered =
                constructorStandingDAOList.stream()
                .filter(constructor -> constructor.getConstructorId() == id)
                .collect(Collectors.toList());
        return constructorFiltered;
    }
}
