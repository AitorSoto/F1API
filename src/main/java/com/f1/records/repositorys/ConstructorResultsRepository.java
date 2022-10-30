package com.f1.records.repositorys;

import com.f1.records.pojos.DAOs.ConstructorResultDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConstructorResultsRepository extends PagingAndSortingRepository<ConstructorResultDAO, Integer> {
    @Query("select c from ConstructorResultDAO c where c.constructorId = ?1")
    Page<ConstructorResultDAO> findByConstructorId(int constructorId, Pageable pageable);

    @Query("select c from ConstructorResultDAO c where c.race.name = ?1 and c.constructor.name = ?2")
    Page<ConstructorResultDAO> findByRaceNameAndConstructorName(String raceName, String constructorName, Pageable pageable);

    @Query("select c from ConstructorResultDAO c where c.race.name = ?1 and c.constructor.name = ?2 and c.race.year = ?3")
    ConstructorResultDAO findByRaceNameAndConstructorNameAndRaceYear(String raceName, String constructorName, int raceYear);



}
