package com.f1.records.services.qualifying;

import com.f1.records.mappers.UniversalMapper;
import com.f1.records.pojos.DAOs.QualifyingDAO;
import com.f1.records.pojos.DTOs.QualifyingDTO;
import com.f1.records.repositorys.QualifyingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QualifyingServiceImpl implements QualifyingService{
    @Autowired
    QualifyingRepository qualifyingRepository;

    @Override
    public List<QualifyingDTO> getAllQualys(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<QualifyingDAO> qualifyings = qualifyingRepository.findAll(pageable);

        return transfromListDAOIntoListDTO(qualifyings.getContent());
    }

    @Override
    public List<QualifyingDTO> getAllQualys(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<QualifyingDAO> qualifyings = qualifyingRepository.findAll(pageable);

        return transfromListDAOIntoListDTO(qualifyings.getContent());
    }

    @Override
    public QualifyingDTO getQualyByRaceIdAndDriverId(int raceId, int driverId) {
        QualifyingDAO qualifyingDAO = qualifyingRepository.getQualifyingDTOByRaceIdAndDriverId(raceId, driverId);

        return UniversalMapper.qualifyingToDTO(qualifyingDAO);
    }

    @Override
    public List<QualifyingDTO> getAllQualysByRaceId(int raceId, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<QualifyingDAO> qualifyings = qualifyingRepository.getQualifyingDTOByRaceId(raceId, pageable);

        return transfromListDAOIntoListDTO(qualifyings.getContent());
    }

    @Override
    public List<QualifyingDTO> getAllQualysByRaceId(int raceId, int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<QualifyingDAO> qualifyings = qualifyingRepository.getQualifyingDTOByRaceId(raceId, pageable);

        return transfromListDAOIntoListDTO(qualifyings.getContent());
    }

    @Override
    public List<QualifyingDTO> getAllQualysByRaceIdAndConstructorId(int raceId, int constructorId) {
        List<QualifyingDAO> qualifyingDAOS = qualifyingRepository.getQualifyingDTOByRaceIdAndConstructorId(raceId, constructorId);

        return transfromListDAOIntoListDTO(qualifyingDAOS);
    }

    private List<QualifyingDTO> transfromListDAOIntoListDTO(List<QualifyingDAO> qualiDAOs){
        List<QualifyingDTO> qualifyingDTOS = new ArrayList<>();
        for(QualifyingDAO result: qualiDAOs){
            qualifyingDTOS.add(UniversalMapper.qualifyingToDTO(result));
        }
        return qualifyingDTOS;
    }
}