package com.f1.records.repositorys;

import com.f1.records.pojos.DAOs.ResultDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends PagingAndSortingRepository<ResultDAO, Integer> {
    @Query(value = "SELECT * " +
            "FROM Results r INNER JOIN Drivers d INNER JOIN Races ra INNER JOIN status s " +
            "INNER JOIN Constructors c INNER JOIN circuits cir " +
            "ON r.race_id = ra.race_id AND r.driver_id = d.driver_id AND ra.circuit_id = cir.circuit_id AND r.constructor_id = c.constructor_id AND s.status_id = r.status_id " +
            "WHERE ra.year = ?1 AND ra.name = ?2", nativeQuery = true)
    Page<ResultDAO> getResultsByRaceYearAndCircuitName(int raceYear, String name, Pageable pageable);

    @Query(value = "SELECT * " +
            "FROM Results r INNER JOIN Drivers d INNER JOIN Races ra INNER JOIN status s " +
            "INNER JOIN Constructors c INNER JOIN circuits cir " +
            "ON r.race_id = ra.race_id AND r.driver_id = d.driver_id AND ra.circuit_id = cir.circuit_id AND r.constructor_id = c.constructor_id AND s.status_id = r.status_id " +
            "WHERE ra.year = ?1 AND ra.name = ?2 AND d.surname = ?4 AND d.forename = ?3", nativeQuery = true)
    ResultDAO getResultsByRaceYearAndCircuitNameAndDriverSurname(int raceYear, String circuitName, String driverName, String driverSurname);
}
