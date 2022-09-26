package com.f1.records.repositorys;

import com.f1.records.pojos.LapTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface LapTimeRepository extends PagingAndSortingRepository<LapTime, Integer> {
    Page<LapTime> getByDriverIdAndRaceId(int driverId, int raceId, Pageable pageable);
}
