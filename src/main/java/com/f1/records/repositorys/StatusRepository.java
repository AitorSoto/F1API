package com.f1.records.repositorys;

import com.f1.records.pojos.DAOs.StatusDAO;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends PagingAndSortingRepository<StatusDAO, Integer> {

}