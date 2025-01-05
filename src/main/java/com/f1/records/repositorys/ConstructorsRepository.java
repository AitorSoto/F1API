package com.f1.records.repositorys;

import com.f1.records.pojos.DAOs.ConstructorDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConstructorsRepository extends PagingAndSortingRepository<ConstructorDAO, Integer> {
    @Query("select c from ConstructorDAO c where c.constructorId = ?1")
    ConstructorDAO findConstructorByConstructorId(int constructorId);

    @Query("select c from ConstructorDAO c where c.name = ?1")
    ConstructorDAO findConstructorByName(String name);

    @Query("SELECT c.name " +
            "FROM ResultDAO r " +
            "JOIN r.constructorDAO c " +
            "JOIN r.raceDAO ra " +
            "WHERE r.driverId = :driverId " +
            "GROUP BY c.name, ra.year " +  // Agrupamos por nombre del constructor y año
            "ORDER BY ra.year DESC")
    List<String> findConstructorsOfId(int driverId);

    /*
    * SELECT constructors.name
    * FROM results
    * INNER JOIN constructors
    * ON results.constructor_id = constructors.constructor_id
    * INNER JOIN races
    * ON results.race_id = races.race_id
    * WHERE results.driver_id = 4
    * GROUP BY races.year
    * ORDER BY races.year desc;*/
}
