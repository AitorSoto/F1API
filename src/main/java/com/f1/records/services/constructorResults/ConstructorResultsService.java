package com.f1.records.services.constructorResults;

import com.f1.records.pojos.ConstructorResult;

import java.util.List;

public interface ConstructorResultsService {
    List<ConstructorResult> getAllConstructorResults();
    List<ConstructorResult> getAllConstructorResultsById(int idConstructor);
}
