package com.f1.records.services.constructorResults;

import com.f1.records.mappers.UniversalMapper;
import com.f1.records.pojos.DAOs.ConstructorResultDAO;
import com.f1.records.pojos.DTOs.ConstructorResultDTO;
import com.f1.records.repositorys.ConstructorResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConstructorResultsServiceImpl implements ConstructorResultsService{
    @Autowired
    ConstructorResultsRepository constructorRepository;

    @Override
    public List<ConstructorResultDTO> getAllConstructorResults(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<ConstructorResultDAO> pages = constructorRepository.findAll(pageable);

        return transformListDAOIntoListDTO(pages.getContent());
    }

    @Override
    public List<ConstructorResultDTO> getAllConstructorResults(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<ConstructorResultDAO> pages = constructorRepository.findAll(pageable);

        return transformListDAOIntoListDTO(pages.getContent());
    }

    @Override
    public List<ConstructorResultDTO> getAllConstructorResultsById(int pageNo, int pageSize, int idConstructor) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<ConstructorResultDAO> pages = constructorRepository.findByConstructorId(idConstructor, pageable);
        return transformListDAOIntoListDTO(pages.getContent());
    }

    @Override
    public List<ConstructorResultDTO> getAllConstructorResultsById(int pageNo, int pageSize, String sortBy, int idConstructor) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<ConstructorResultDAO> pages = constructorRepository.findByConstructorId(idConstructor, pageable);
        return transformListDAOIntoListDTO(pages.getContent());
    }

    @Override
    public List<ConstructorResultDTO> getAllConstructorResultsByRaceNameAndConstructorName(int pageNo, int pageSize, String raceName, String constructorName) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<ConstructorResultDAO> pages = constructorRepository.findByRaceNameAndConstructorName(raceName, constructorName, pageable);

        return transformListDAOIntoListDTO(pages.getContent());
    }

    @Override
    public List<ConstructorResultDTO> getAllConstructorResultsByRaceNameAndConstructorName(int pageNo, int pageSize, String sortBy, String raceName, String constructorName) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<ConstructorResultDAO> pages = constructorRepository.findByRaceNameAndConstructorName(raceName, constructorName, pageable);

        return transformListDAOIntoListDTO(pages.getContent());
    }

    @Override
    public ConstructorResultDTO getAllConstructorResultsByRaceNameAndConstructorNameAndRaceYear(String raceName, String constructorName, int raceYear) {
        ConstructorResultDAO constructorResultDAO = constructorRepository.findByRaceNameAndConstructorNameAndRaceYear(raceName, constructorName, raceYear);
        return UniversalMapper.constructorResultToDTO(constructorResultDAO);
    }

    private List<ConstructorResultDTO> transformListDAOIntoListDTO(List<ConstructorResultDAO> constructorResultDAOS){
        List<ConstructorResultDTO> constructorResultDTOS = new ArrayList<>();
        for(ConstructorResultDAO result: constructorResultDAOS){
            constructorResultDTOS.add(UniversalMapper.constructorResultToDTO(result));
        }
        return constructorResultDTOS;
    }
}
