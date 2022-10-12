package com.f1.records.repositorys;

import com.f1.records.pojos.DTOs.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends CrudRepository<Status, Integer> {

}