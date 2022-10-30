package com.f1.records.services.constructorStandings;

import com.f1.records.mappers.UniversalMapper;
import com.f1.records.pojos.DAOs.ConstructorStandingDAO;
import com.f1.records.pojos.DTOs.ConstructorStandingDTO;
import com.f1.records.repositorys.ConstructorsStandingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConstructorStandingsServiceImpl implements ConstructorStandingsService {
    @Autowired
    ConstructorsStandingsRepository constructorsStandingsRepository;

    @Override
    public List<ConstructorStandingDTO> findAllConstructorStandings(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page constructorStandings = constructorsStandingsRepository.findAll(pageable);
        return transformListDAOIntoListDTO(constructorStandings.getContent());
    }

    @Override
    public List<ConstructorStandingDTO> findAllConstructorStandings(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page constructorStandings = constructorsStandingsRepository.findAll(pageable);
        return transformListDAOIntoListDTO(constructorStandings.getContent());
    }

    @Override
    public List<ConstructorStandingDTO> findConstructorStandingsById(int pageNo, int pageSize, int id) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page constructorStandings = constructorsStandingsRepository.findDriverStandingDAOByConstructorStandingsId(id, pageable);
        return transformListDAOIntoListDTO(constructorStandings.getContent());
    }

    @Override
    public List<ConstructorStandingDTO> findConstructorStandingsById(int pageNo, int pageSize, String sortBy, int id) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page constructorStandings = constructorsStandingsRepository.findDriverStandingDAOByConstructorStandingsId(id, pageable);
        return transformListDAOIntoListDTO(constructorStandings.getContent());
    }

    @Override
    public ConstructorStandingDTO findConstructorStandingDTOByRaceNameAndRaceYearAndConstructorName(String raceName, int raceYear, String constructorName) {
        ConstructorStandingDAO constructorStandingDAO =
                constructorsStandingsRepository.findConstructorStandingDTOByRaceNameAndRaceYearAndConstructorName(raceName, raceYear, constructorName);
        return UniversalMapper.constructorStandingToDTO(constructorStandingDAO);
    }

    private List<ConstructorStandingDTO> transformListDAOIntoListDTO(List<ConstructorStandingDAO> constructorStandingDAOS){
        List<ConstructorStandingDTO> constructorStandingDTOS = new ArrayList<>();
        for(ConstructorStandingDAO result: constructorStandingDAOS){
            constructorStandingDTOS.add(UniversalMapper.constructorStandingToDTO(result));
        }
        return constructorStandingDTOS;
    }
}
