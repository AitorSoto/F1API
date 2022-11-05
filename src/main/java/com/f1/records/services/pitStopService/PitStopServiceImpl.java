package com.f1.records.services.pitStopService;

import com.f1.records.mappers.UniversalMapper;
import com.f1.records.pojos.DAOs.PitStopDAO;
import com.f1.records.pojos.DTOs.PitStopDTO;
import com.f1.records.repositorys.PitStopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PitStopServiceImpl implements PitStopService {
    @Autowired
    PitStopRepository pitStopRepository;

    @Override
    public List<PitStopDTO> findAllPitStops(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<PitStopDAO> pitStops = pitStopRepository.findAll(pageable);

        return transformListDAOIntoListDTO(pitStops.getContent());
    }

    @Override
    public List<PitStopDTO> findAllPitStops(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<PitStopDAO> pitStops = pitStopRepository.findAll(pageable);

        return transformListDAOIntoListDTO(pitStops.getContent());
    }

    @Override
    public List<PitStopDTO> findByDriverId(int driverId, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<PitStopDAO> pitStops = pitStopRepository.findPitStopDTOByDriverId(driverId, pageable);

        return transformListDAOIntoListDTO(pitStops.getContent());
    }

    @Override
    public List<PitStopDTO> findByDriverId(int driverId, int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<PitStopDAO> pitStops = pitStopRepository.findPitStopDTOByDriverId(driverId, pageable);

        return transformListDAOIntoListDTO(pitStops.getContent());
    }

    @Override
    public List<PitStopDTO> findByDriverIdAndRaceId(int driverId, int raceId, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<PitStopDAO> pitStops = pitStopRepository.findPitStopDTOByDriverIdAndRaceId(driverId, raceId, pageable);

        return transformListDAOIntoListDTO(pitStops.getContent());
    }

    @Override
    public List<PitStopDTO> findByDriverIdAndRaceId(int driverId, int raceId, int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<PitStopDAO> pitStops = pitStopRepository.findPitStopDTOByDriverIdAndRaceId(driverId, raceId, pageable);

        return transformListDAOIntoListDTO(pitStops.getContent());
    }

    @Override
    public List<PitStopDTO> findByRaceNameAndYear(String raceName, int year, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<PitStopDAO> pages = pitStopRepository.findByRaceNameAndYear(year, raceName, pageable);

        return transformListDAOIntoListDTO(pages.getContent());
    }

    @Override
    public List<PitStopDTO> findByRaceNameAndYear(String raceName, int year, int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<PitStopDAO> pages = pitStopRepository.findByRaceNameAndYear(year, raceName, pageable);

        return transformListDAOIntoListDTO(pages.getContent());
    }

    @Override
    public List<PitStopDTO> findByRaceName(String raceName, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<PitStopDAO> pages = pitStopRepository.findByRaceName(raceName, pageable);

        return transformListDAOIntoListDTO(pages.getContent());
    }

    @Override
    public List<PitStopDTO> findByRaceName(String raceName, int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<PitStopDAO> pages = pitStopRepository.findByRaceName(raceName, pageable);

        return transformListDAOIntoListDTO(pages.getContent());
    }

    @Override
    public List<PitStopDTO> findByRaceNameAndRaceYearAndDriverFullName(String raceName, int year, String driverForename, String driverSurname, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<PitStopDAO> pages = pitStopRepository.findByRaceNameAndRaceYearAndDriverFullName(raceName, year, driverForename, driverSurname, pageable);

        return transformListDAOIntoListDTO(pages.getContent());
    }

    @Override
    public List<PitStopDTO> findByRaceNameAndRaceYearAndDriverFullName(String raceName, int year, String driverForename, String driverSurname, int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<PitStopDAO> pages = pitStopRepository.findByRaceNameAndRaceYearAndDriverFullName(raceName, year, driverForename, driverSurname, pageable);

        return transformListDAOIntoListDTO(pages.getContent());
    }

    private List<PitStopDTO> transformListDAOIntoListDTO(List<PitStopDAO> pitStopDAOs){
        List<PitStopDTO> pitStopDTOS = new ArrayList<>();
        for(PitStopDAO result: pitStopDAOs){
            pitStopDTOS.add(UniversalMapper.pitStopToDTO(result));
        }
        return pitStopDTOS;
    }
}
