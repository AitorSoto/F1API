package com.f1.records.services.qualifying;

import com.f1.records.pojos.DTOs.Qualifying;
import com.f1.records.repositorys.QualifyingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualifyingServiceImpl implements QualifyingService{
    @Autowired
    QualifyingRepository qualifyingRepository;

    @Override
    public List<Qualifying> getAllQualys(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Qualifying> qualifyings = qualifyingRepository.findAll(pageable);

        return qualifyings.getContent();
    }

    @Override
    public List<Qualifying> getAllQualys(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Qualifying> qualifyings = qualifyingRepository.findAll(pageable);

        return qualifyings.getContent();
    }

    @Override
    public Qualifying getQualyByRaceIdAndDriverId(int raceId, int driverId) {
        Qualifying qualifying = qualifyingRepository.getQualifyingByRaceIdAndDriverId(raceId, driverId);

        return qualifying;
    }

    @Override
    public List<Qualifying> getAllQualysByRaceId(int raceId, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Qualifying> qualifyings = qualifyingRepository.getQualifyingsByRaceId(raceId, pageable);

        return qualifyings.getContent();
    }

    @Override
    public List<Qualifying> getAllQualysByRaceId(int raceId, int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Qualifying> qualifyings = qualifyingRepository.getQualifyingsByRaceId(raceId, pageable);

        return qualifyings.getContent();
    }

    @Override
    public List<Qualifying> getAllQualysByRaceIdAndConstructorId(int raceId, int constructorId) {
        List<Qualifying> qualifyings = qualifyingRepository.getQualifyingsByRaceIdAndConstructorId(raceId, constructorId);

        return qualifyings;
    }
}
