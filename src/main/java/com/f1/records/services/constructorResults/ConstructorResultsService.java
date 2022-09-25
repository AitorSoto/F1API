package com.f1.records.services.constructorResults;

import com.f1.records.pojos.ConstructorResults;

import java.util.List;

public interface ConstructorResultsService {
    List<ConstructorResults> getAllConstructorResults();
    List<ConstructorResults> getAllConstructorResultsById(int idConstructor);
}
