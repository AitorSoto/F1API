package com.f1.records.repositorys;

import com.f1.records.pojos.DAOs.PitStopDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PitStopRepository extends PagingAndSortingRepository<PitStopDAO, Integer> {
    @Query("select p from PitStopDAO p where p.raceDAO.year = ?1 and p.raceDAO.name = ?2")
    Page<PitStopDAO> findByRaceNameAndYear(int year, String raceName, Pageable pageable);

    @Query("select p from PitStopDAO p where p.raceDAO.name = ?1")
    Page<PitStopDAO> findByRaceName(String raceName, Pageable pageable);

    @Query("select p from PitStopDAO p " +
            "where p.raceDAO.name = ?1 and p.raceDAO.year = ?2 and p.driverDAO.forename = ?3 and p.driverDAO.surname = ?4")
    Page<PitStopDAO> findByRaceNameAndRaceYearAndDriverFullName(String name, int year, String forename, String surname, Pageable pageable);

    Page<PitStopDAO> findPitStopDTOByDriverId(int driverId, Pageable pageable);
    Page<PitStopDAO> findPitStopDTOByDriverIdAndRaceId(int driverId, int raceId, Pageable pageable);


}
