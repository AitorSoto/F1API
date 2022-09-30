package com.f1.records.repositorys;

import com.f1.records.pojos.ConstructorResult;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConstructorResultsRepository extends CrudRepository<ConstructorResult, Integer> {
}
