package com.f1.records.repositorys;

import com.f1.records.pojos.DTOs.Qualifying;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QualifyingRepository extends PagingAndSortingRepository<Qualifying, Integer> {
    Page<Qualifying> getQualifyingsByRaceId(int raceId, Pageable pageable);
    Qualifying getQualifyingByRaceIdAndDriverId(int raceId, int driverId);
    List<Qualifying> getQualifyingsByRaceIdAndConstructorId(int raceId, int constructorId);
}
