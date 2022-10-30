package com.f1.records.services.race;

import com.f1.records.mappers.UniversalMapper;
import com.f1.records.pojos.DAOs.RaceDAO;
import com.f1.records.pojos.DTOs.RaceDTO;
import com.f1.records.repositorys.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RaceServiceImpl implements RaceService{
    @Autowired
    RaceRepository raceRepository;

    @Override
    public List<RaceDTO> getAllRaces(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page pages = raceRepository.findAll(pageable);
        return transformListDTOIntoListDTO(pages.getContent());
    }

    @Override
    public List<RaceDTO> getAllRaces(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page pages = raceRepository.findAll(pageable);
        return transformListDTOIntoListDTO(pages.getContent());
    }

    @Override
    public List<RaceDTO> getRacesByYear(int pageNo, int pageSize, int year) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page pages = raceRepository.getRacesByYear(year, pageable);
        return transformListDTOIntoListDTO(pages.getContent());
    }

    @Override
    public List<RaceDTO> getRacesByYear(int pageNo, int pageSize, String sortBy, int year) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page pages = raceRepository.getRacesByYear(year, pageable);
        return transformListDTOIntoListDTO(pages.getContent());
    }

    @Override
    public RaceDTO getRacesByRoundAndYear(int round, int year) {
        RaceDAO race = raceRepository.getRaceByRoundAndYear(round, year);
        return UniversalMapper.raceToDTO(race);
    }

    @Override
    public List<RaceDTO> getRacesByCircuit(int pageNo, int pageSize, String circuitName) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page pages = raceRepository.getRacesByCircuit(circuitName, pageable);
        return transformListDTOIntoListDTO(pages.getContent());
    }

    @Override
    public List<RaceDTO> getRacesByCircuit(int pageNo, int pageSize, String sortBy, String circuitName) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page pages = raceRepository.getRacesByCircuit(circuitName, pageable);
        return transformListDTOIntoListDTO(pages.getContent());
    }

    @Override
    public List<RaceDTO> getRacesByCountry(int pageNo, int pageSize, String country) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page pages = raceRepository.getRacesByCountry(country, pageable);
        return transformListDTOIntoListDTO(pages.getContent());
    }

    @Override
    public List<RaceDTO> getRacesByCountry(int pageNo, int pageSize, String sortBy, String country) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page pages = raceRepository.getRacesByCountry(country, pageable);
        return transformListDTOIntoListDTO(pages.getContent());
    }

    private List<RaceDTO> transformListDTOIntoListDTO(List<RaceDAO> raceDAOS){
        List<RaceDTO> raceDTOS = new ArrayList<>();
        for(RaceDAO result: raceDAOS){
            raceDTOS.add(UniversalMapper.raceToDTO(result));
        }
        return raceDTOS;
    }
}
