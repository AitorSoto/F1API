package com.f1.records.services.qualifying;

import com.f1.records.pojos.DAOs.QualifyingDAO;
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
    public List<QualifyingDAO> getAllQualys(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<QualifyingDAO> qualifyings = qualifyingRepository.findAll(pageable);

        return qualifyings.getContent();
    }

    @Override
    public List<QualifyingDAO> getAllQualys(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<QualifyingDAO> qualifyings = qualifyingRepository.findAll(pageable);

        return qualifyings.getContent();
    }

    @Override
    public QualifyingDAO getQualyByRaceIdAndDriverId(int raceId, int driverId) {
        QualifyingDAO qualifyingDAO = qualifyingRepository.getQualifyingDTOByRaceIdAndDriverId(raceId, driverId);

        return qualifyingDAO;
    }

    @Override
    public List<QualifyingDAO> getAllQualysByRaceId(int raceId, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<QualifyingDAO> qualifyings = qualifyingRepository.getQualifyingDTOByRaceId(raceId, pageable);

        return qualifyings.getContent();
    }

    @Override
    public List<QualifyingDAO> getAllQualysByRaceId(int raceId, int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<QualifyingDAO> qualifyings = qualifyingRepository.getQualifyingDTOByRaceId(raceId, pageable);

        return qualifyings.getContent();
    }

    @Override
    public List<QualifyingDAO> getAllQualysByRaceIdAndConstructorId(int raceId, int constructorId) {
        List<QualifyingDAO> qualifyingDAOS = qualifyingRepository.getQualifyingDTOByRaceIdAndConstructorId(raceId, constructorId);

        return qualifyingDAOS;
    }
}
