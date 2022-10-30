package com.f1.records.repositorys;

import com.f1.records.pojos.DAOs.ConstructorStandingDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructorsStandingsRepository extends PagingAndSortingRepository<ConstructorStandingDAO, Integer> {
    Page<ConstructorStandingDAO> findDriverStandingDAOByConstructorStandingsId(int id, Pageable pageable);

    @Query("select c from ConstructorStandingDAO c " +
            "where c.raceDAO.name = ?1 and c.raceDAO.year = ?2 and c.constructorDAO.name = ?3")
    ConstructorStandingDAO findConstructorStandingDTOByRaceNameAndRaceYearAndConstructorName(String raceName, int year, String constructorName);
}
