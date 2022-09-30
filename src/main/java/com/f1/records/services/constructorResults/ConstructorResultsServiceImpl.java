package com.f1.records.services.constructorResults;

import com.f1.records.pojos.ConstructorResult;
import com.f1.records.repositorys.ConstructorResultsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConstructorResultsServiceImpl implements ConstructorResultsService{
    @Autowired
    ConstructorResultsRepository constructorRespository;

    @Override
    public List<ConstructorResult> getAllConstructorResults() {
        Iterable<ConstructorResult> optionalResults = constructorRespository.findAll();
        List<ConstructorResult> constructorResults = new ArrayList<>();
        optionalResults.forEach(constructorResults::add);
        return constructorResults;
    }

    @Override
    public List<ConstructorResult> getAllConstructorResultsById(int idConstructor) {
        Iterable<ConstructorResult> optionalResults = constructorRespository.findAll();
        List<ConstructorResult> constructorResults = new ArrayList<>();
        optionalResults.forEach(constructorResults::add);
        List<ConstructorResult> filteredConstructorResults =
                constructorResults.stream()
                .filter(constructor -> constructor.getConstructorId() == idConstructor)
                .collect(Collectors.toList());
        return filteredConstructorResults;
    }
}
