package com.f1.records.repositorys;

import com.f1.records.pojos.DAOs.CircuitDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CircuitRepository extends PagingAndSortingRepository<CircuitDAO, Integer> {
    @Query("select c from CircuitDAO c where c.name = ?1")
    CircuitDAO getCircuitByName(String name);

    @Query("select c from CircuitDAO c where c.country = ?1")
    List<CircuitDAO> getCircuitsByCountry(String country);
}
