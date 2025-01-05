package com.f1.records.repositorys;

import com.f1.records.pojos.DAOs.RaceDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RaceRepository extends PagingAndSortingRepository<RaceDAO, Integer> {
    @Query("select r from RaceDAO r where r.year = ?1")
    Page<RaceDAO> getRacesByYear(int year, Pageable pageable);

    @Query("select r from RaceDAO r where r.round = ?1 and r.year = ?2")
    RaceDAO getRaceByRoundAndYear(int round, int year);

    @Query("select r from RaceDAO r where r.circuitDAO.name = ?1")
    Page<RaceDAO> getRacesByCircuit(String name, Pageable pageable);

    @Query("select r from RaceDAO r where r.circuitDAO.country = ?1")
    Page<RaceDAO> getRacesByCountry(String country, Pageable pageable);

    @Query("select count(r) from RaceDAO r")
    long getRacesNumber();


}
