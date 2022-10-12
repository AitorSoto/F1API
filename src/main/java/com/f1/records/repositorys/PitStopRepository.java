package com.f1.records.repositorys;

import com.f1.records.pojos.DTOs.PitStop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PitStopRepository extends PagingAndSortingRepository<PitStop, Integer> {
    Page<PitStop> findPitStopsByDriverId(int driverId, Pageable pageable);
    Page<PitStop> findPitStopsByDriverIdAndRaceId(int driverId, int raceId, Pageable pageable);
}
