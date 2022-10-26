package com.f1.records.services.constructorResults;

import com.f1.records.pojos.DAOs.ConstructorResultDAO;

import java.util.List;

public interface ConstructorResultsService {
    List<ConstructorResultDAO> getAllConstructorResults();
    List<ConstructorResultDAO> getAllConstructorResultsById(int idConstructor);
}
