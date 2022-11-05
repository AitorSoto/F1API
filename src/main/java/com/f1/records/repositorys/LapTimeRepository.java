package com.f1.records.repositorys;

import com.f1.records.pojos.DAOs.LapTimeDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;



public interface LapTimeRepository extends PagingAndSortingRepository<LapTimeDAO, Integer> {
    @Query("SELECT l FROM LapTimeDAO l WHERE l.driverId = ?1 AND l.raceId = ?2")
    Page<LapTimeDAO> getAllLapsTimesByDriverIdAndRaceId(int driverId, int raceId, Pageable pageable);

    @Query("select l from LapTimeDAO l " +
            "where l.driverDAO.forename = ?1 and l.driverDAO.surname = ?2 and l.raceDAO.name = ?3 and l.raceDAO.year = ?4")
    Page<LapTimeDAO> getAllLapTimesByDriverFullNameAndRaceNameAndYear(String forename, String surname, String raceName, int year, Pageable pageable);
}
