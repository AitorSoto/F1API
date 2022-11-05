package com.f1.records.services.driverStandingsService;

import com.f1.records.mappers.UniversalMapper;
import com.f1.records.pojos.DAOs.DriverStandingDAO;
import com.f1.records.pojos.DTOs.DriverStandingDTO;
import com.f1.records.repositorys.DriverStandingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DriverStandingsServiceImpl implements DriverStandingsService{
    @Autowired
    DriverStandingsRepository driverStandingsRepository;

    @Override
    public List<DriverStandingDTO> findAllDriverStandings(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<DriverStandingDAO> driverStandings = driverStandingsRepository.findAll(pageable);
        return transformListDAOIntoListDTO(driverStandings.getContent());
    }

    @Override
    public List<DriverStandingDTO> findAllDriverStandings(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<DriverStandingDAO> driverStandings = driverStandingsRepository.findAll(pageable);
        return transformListDAOIntoListDTO(driverStandings.getContent());
    }

    @Override
    public List<DriverStandingDTO> findDriverStandingsByDriverId(int pageNo, int pageSize, int driverId) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<DriverStandingDAO> driverStandings = driverStandingsRepository.getDriverDTOStandingsByDriverId(driverId, pageable);
        return transformListDAOIntoListDTO(driverStandings.getContent());
    }

    @Override
    public List<DriverStandingDTO> findDriverStandingsByDriverId(int pageNo, int pageSize, String sortBy, int driverId) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<DriverStandingDAO> driverStandings = driverStandingsRepository.getDriverDTOStandingsByDriverId(driverId, pageable);
        return transformListDAOIntoListDTO(driverStandings.getContent());
    }

    @Override
    public DriverStandingDTO findDriverStandingsByDriverIdAndRaceId(int driverId, int raceId) {
        DriverStandingDAO driverStandings =
                driverStandingsRepository.getDriverDTOStandingsByDriverIdAndRaceId(driverId, raceId);
        return UniversalMapper.driverStandingToDTO(driverStandings);
    }

    @Override
    public List<DriverStandingDTO> getDriverStandingsByDriverFullName(int pageNo, int pageSize, String forename, String surname) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<DriverStandingDAO> pages = driverStandingsRepository.getDriverStandingsByDriverFullName(forename, surname, pageable);
        return transformListDAOIntoListDTO(pages.getContent());
    }

    @Override
    public List<DriverStandingDTO> getDriverStandingsByDriverFullName(int pageNo, int pageSize, String sortBy, String forename, String surname) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<DriverStandingDAO> pages = driverStandingsRepository.getDriverStandingsByDriverFullName(forename, surname, pageable);
        return transformListDAOIntoListDTO(pages.getContent());
    }

    @Override
    public DriverStandingDTO getDriverStandingsByDriverFullNameRaceName(String forename, String surname, String raceName, int year) {
        DriverStandingDAO driverStandingDAO = driverStandingsRepository.getDriverStandingsByDriverFullNameRaceNameAndYear(forename, surname, raceName, year);
        return UniversalMapper.driverStandingToDTO(driverStandingDAO);
    }

    private List<DriverStandingDTO> transformListDAOIntoListDTO(List<DriverStandingDAO> driverStandingDAOS){
        List<DriverStandingDTO> driverStandingDTOS = new ArrayList<>();
        for(DriverStandingDAO result: driverStandingDAOS){
            driverStandingDTOS.add(UniversalMapper.driverStandingToDTO(result));
        }
        return driverStandingDTOS;
    }
}
