package com.f1.records.repositorys;

import com.f1.records.pojos.DAOs.DriverDAO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends PagingAndSortingRepository<DriverDAO, Integer> {
    DriverDAO getDriverDAOByForenameAndSurname(String forename, String surname);

    @Query("select count(d) from DriverDAO d")
    long getNumberOfDrivers();
}
