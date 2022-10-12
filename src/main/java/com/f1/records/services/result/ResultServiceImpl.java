package com.f1.records.services.result;

import com.f1.records.pojos.DTOs.Result;
import com.f1.records.repositorys.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ResultServiceImpl implements ResultService{
    @Autowired
    ResultRepository resultRepository;

    @Override
    public List<Result> getAllResults(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page results = resultRepository.findAll(pageable);

        return results.getContent();
    }

    @Override
    public List<Result> getAllResults(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page results = resultRepository.findAll(pageable);

        return results.getContent();
    }

    @Override
    public List<Result> getResultsByRaceYearAndRaceName(int pageNo, int pageSize, int raceYear, String circuitName) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page results = resultRepository.getResultsByRaceYearAndCircuitName(raceYear, circuitName, pageable);

        return results.getContent();
    }

    @Override
    public List<Result> getResultsByRaceYearAndRaceName(int pageNo, int pageSize, String sortBy, int raceYear, String circuitName) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page results = resultRepository.getResultsByRaceYearAndCircuitName(raceYear, circuitName, pageable);

        return results.getContent();
    }

    @Override
    public Result getResultsByRaceYearAndCircuitNameAndDriverSurname(int raceYear, String circuitName, String driverName, String driverSurname) {
        Result result = resultRepository.getResultsByRaceYearAndCircuitNameAndDriverSurname(raceYear, circuitName, driverName, driverSurname);
        System.out.println(result);
        return result;
    }
}
