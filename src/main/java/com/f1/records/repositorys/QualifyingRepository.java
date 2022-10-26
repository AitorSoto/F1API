package com.f1.records.repositorys;

import com.f1.records.pojos.DAOs.QualifyingDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QualifyingRepository extends PagingAndSortingRepository<QualifyingDAO, Integer> {
    Page<QualifyingDAO> getQualifyingDTOByRaceId(int raceId, Pageable pageable);
    QualifyingDAO getQualifyingDTOByRaceIdAndDriverId(int raceId, int driverId);
    List<QualifyingDAO> getQualifyingDTOByRaceIdAndConstructorId(int raceId, int constructorId);
}
