package com.f1.records.repositorys;

import com.f1.records.pojos.DAOs.PitStopDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PitStopRepository extends PagingAndSortingRepository<PitStopDAO, Integer> {
    Page<PitStopDAO> findPitStopDTOByDriverId(int driverId, Pageable pageable);
    Page<PitStopDAO> findPitStopDTOByDriverIdAndRaceId(int driverId, int raceId, Pageable pageable);
}
