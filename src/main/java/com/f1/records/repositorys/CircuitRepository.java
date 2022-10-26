package com.f1.records.repositorys;

import com.f1.records.pojos.DAOs.CircuitDAO;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CircuitRepository extends PagingAndSortingRepository<CircuitDAO, Integer> {
    CircuitDAO getCircuitByName(String circuitName);
}
