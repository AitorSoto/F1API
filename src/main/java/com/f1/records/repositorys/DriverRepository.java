package com.f1.records.repositorys;

import com.f1.records.pojos.DAOs.DriverDAO;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface DriverRepository extends PagingAndSortingRepository<DriverDAO, Integer> {
    DriverDAO getDriverDAOByForenameAndSurname(String forename, String surname);

    @Query("select count(d) from DriverDAO d")
    long getNumberOfDrivers();

    @Query("SELECT d FROM DriverDAO d INNER JOIN ResultDAO r ON d.driverId = r.driverId WHERE r.position = 1 GROUP BY d.driverId ORDER BY COUNT(DISTINCT r.raceId) DESC")
    Page<DriverDAO> getAllDriversOrderedByVictories(Pageable pageable);

    @Query("SELECT d " +
            "FROM DriverDAO d " +
            "WHERE LOWER(d.forename) LIKE LOWER(CONCAT('%', :searchParam, '%')) " +
            "   OR LOWER(d.surname) LIKE LOWER(CONCAT('%', :searchParam, '%'))")
    List<DriverDAO> searchDrivers(@Param("searchParam") String searchParam);
}
