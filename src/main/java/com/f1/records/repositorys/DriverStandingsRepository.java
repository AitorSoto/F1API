package com.f1.records.repositorys;

import com.f1.records.pojos.DAOs.DriverStandingDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

@Repository
public interface DriverStandingsRepository extends PagingAndSortingRepository<DriverStandingDAO, Integer> {
    Page<DriverStandingDAO> getDriverDTOStandingsByDriverId(int driverId, Pageable pageable);
    Page<DriverStandingDAO> getDriverDTOStandingsByDriverIdAndRaceId(int driverId, int raceId, Pageable pageable);
}
