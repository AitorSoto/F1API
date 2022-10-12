package com.f1.records.repositorys;

import com.f1.records.pojos.DTOs.LapTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface LapTimeRepository extends PagingAndSortingRepository<LapTime, Integer> {
    @Query("SELECT l FROM LapTime l WHERE l.driverId = ?1 AND l.raceId = ?2")
    Page<LapTime> getAllLapsTimesByDriverIdAndRaceId(int driverId, int raceId, Pageable pageable);
}
