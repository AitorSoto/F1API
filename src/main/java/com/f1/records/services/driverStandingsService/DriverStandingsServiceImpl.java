package com.f1.records.services.driverStandingsService;

import com.f1.records.pojos.DriverStanding;
import com.f1.records.repositorys.DriverStandingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverStandingsServiceImpl implements DriverStandingsService{
    @Autowired
    DriverStandingsRepository driverStandingsRepository;

    @Override
    public List<DriverStanding> findAllDriverStandings(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<DriverStanding> driverStandings = driverStandingsRepository.findAll(pageable);
        return driverStandings.getContent();
    }

    @Override
    public List<DriverStanding> findAllDriverStandings(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<DriverStanding> driverStandings = driverStandingsRepository.findAll(pageable);
        return driverStandings.getContent();
    }

    @Override
    public List<DriverStanding> findDriverStandingsByDriverId(int pageNo, int pageSize, int driverId) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<DriverStanding> driverStandings = driverStandingsRepository.getDriversStandingsByDriverId(driverId, pageable);
        return driverStandings.getContent();
    }

    @Override
    public List<DriverStanding> findDriverStandingsByDriverId(int pageNo, int pageSize, String sortBy, int driverId) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<DriverStanding> driverStandings = driverStandingsRepository.getDriversStandingsByDriverId(driverId, pageable);
        return driverStandings.getContent();
    }

    @Override
    public DriverStanding findDriverStandingsByDriverIdAndRaceId(int pageNo, int pageSize, int driverId, int raceId) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<DriverStanding> driverStandings =
                driverStandingsRepository.getDriversStandingsByDriverIdAndRaceId(driverId, raceId, pageable);
        return driverStandings.getContent().get(0);
    }

    @Override
    public DriverStanding findDriverStandingsByDriverIdAndRaceId(int pageNo, int pageSize, String sortBy, int driverId, int raceId) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<DriverStanding> driverStandings =
                driverStandingsRepository.getDriversStandingsByDriverIdAndRaceId(driverId, raceId, pageable);
        return driverStandings.getContent().get(0);
    }
}
