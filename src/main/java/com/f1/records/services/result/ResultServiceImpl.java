package com.f1.records.services.result;

import com.f1.records.mappers.UniversalMapper;
import com.f1.records.pojos.DAOs.ResultDAO;
import com.f1.records.pojos.DTOs.ResultDTO;
import com.f1.records.repositorys.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService{
    @Autowired
    ResultRepository resultRepository;

    @Override
    public List<ResultDTO> getAllResults(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page results = resultRepository.findAll(pageable);
        return transfromListDTOIntoListDTO(results.getContent());
    }

    @Override
    public List<ResultDTO> getAllResults(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page results = resultRepository.findAll(pageable);

        return transfromListDTOIntoListDTO(results.getContent());
    }

    @Override
    public List<ResultDTO> getResultsByRaceYearAndRaceName(int pageNo, int pageSize, int raceYear, String circuitName) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page results = resultRepository.getResultsByRaceYearAndCircuitName(raceYear, circuitName, pageable);

        return transfromListDTOIntoListDTO(results.getContent());
    }

    @Override
    public List<ResultDTO> getResultsByRaceYearAndRaceName(int pageNo, int pageSize, String sortBy, int raceYear, String circuitName) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page results = resultRepository.getResultsByRaceYearAndCircuitName(raceYear, circuitName, pageable);
        return transfromListDTOIntoListDTO(results.getContent());
    }

    @Override
    public ResultDTO getResultsByRaceYearAndCircuitNameAndDriverSurname(int raceYear, String circuitName, String driverName, String driverSurname) {
        ResultDAO resultDAO = resultRepository.getResultsByRaceYearAndCircuitNameAndDriverSurname(raceYear, circuitName, driverName, driverSurname);
        return UniversalMapper.resultToDTO(resultDAO);
    }

    private List<ResultDTO> transfromListDTOIntoListDTO(List<ResultDAO> daos){
        List<ResultDTO> resultDTOS = new ArrayList<>();
        for(ResultDAO result: daos){
            resultDTOS.add(UniversalMapper.resultToDTO(result));
        }
        return resultDTOS;
    }
}
