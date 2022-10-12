package com.f1.records.repositorys;

import com.f1.records.pojos.DTOs.Constructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstructorsRepository extends CrudRepository<Constructor, Integer> {

}
