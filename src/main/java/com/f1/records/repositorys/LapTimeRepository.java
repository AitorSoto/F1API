package com.f1.records.repositorys;

import com.f1.records.pojos.DAOs.LapTimeDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface LapTimeRepository extends PagingAndSortingRepository<LapTimeDAO, Integer> {
    @Query("SELECT l FROM LapTimeDAO l WHERE l.driverId = ?1 AND l.raceId = ?2")
    Page<LapTimeDAO> getAllLapsTimesByDriverIdAndRaceId(int driverId, int raceId, Pageable pageable); //hacer relaciones para no buscar por id
}
