package com.f1.records.repositorys;

import com.f1.records.pojos.DAOs.StatusDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends CrudRepository<StatusDAO, Integer> {

}