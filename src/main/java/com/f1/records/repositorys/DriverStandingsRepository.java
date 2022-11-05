package com.f1.records.repositorys;

import com.f1.records.pojos.DAOs.DriverStandingDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;

@Repository
public interface DriverStandingsRepository extends PagingAndSortingRepository<DriverStandingDAO, Integer> {
    Page<DriverStandingDAO> getDriverDTOStandingsByDriverId(int driverId, Pageable pageable);
    DriverStandingDAO getDriverDTOStandingsByDriverIdAndRaceId(int driverId, int raceId);

    @Query("select d from DriverStandingDAO d where d.driverDAO.forename = ?1 and d.driverDAO.surname = ?2")
    Page<DriverStandingDAO> getDriverStandingsByDriverFullName(String forename, String surname, Pageable pageable);

    @Query("select d from DriverStandingDAO d " +
            "where d.driverDAO.forename = ?1 and d.driverDAO.surname = ?2 and d.raceDAO.name = ?3 and d.raceDAO.year = ?4")
    DriverStandingDAO getDriverStandingsByDriverFullNameRaceNameAndYear(String forename, String surname, String name, int year);
}
