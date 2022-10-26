package com.f1.records.repositorys;

import com.f1.records.pojos.DAOs.ConstructorResultDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConstructorResultsRepository extends CrudRepository<ConstructorResultDAO, Integer> {
}
