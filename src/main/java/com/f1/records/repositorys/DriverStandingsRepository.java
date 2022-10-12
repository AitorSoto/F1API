package com.f1.records.repositorys;

import com.f1.records.pojos.DTOs.DriverStanding;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

@Repository
public interface DriverStandingsRepository extends PagingAndSortingRepository<DriverStanding, Integer> {
    Page<DriverStanding> getDriversStandingsByDriverId(int driverId, Pageable pageable);
    Page<DriverStanding> getDriversStandingsByDriverIdAndRaceId(int driverId, int raceId, Pageable pageable);
}
