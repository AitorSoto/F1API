package com.f1.records.repositorys;

import com.f1.records.pojos.DAOs.DriverDAO;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository  extends PagingAndSortingRepository<DriverDAO, Integer> {
    DriverDAO getDriverDTOBySurname(String surname);
}
