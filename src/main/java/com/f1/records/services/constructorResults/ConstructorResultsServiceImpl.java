package com.f1.records.services.constructorResults;

import com.f1.records.pojos.ConstructorResults;
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
    public List<ConstructorResults> getAllConstructorResults() {
        Iterable<ConstructorResults> optionalResults = constructorRespository.findAll();
        List<ConstructorResults> constructorResults = new ArrayList<>();
        optionalResults.forEach(constructorResults::add);
        return constructorResults;
    }

    @Override
    public List<ConstructorResults> getAllConstructorResultsById(int idConstructor) {
        Iterable<ConstructorResults> optionalResults = constructorRespository.findAll();
        List<ConstructorResults> constructorResults = new ArrayList<>();
        optionalResults.forEach(constructorResults::add);
        List<ConstructorResults> filteredConstructorResults =
                constructorResults.stream()
                .filter(constructor -> constructor.getConstructorId() == idConstructor)
                .collect(Collectors.toList());
        return filteredConstructorResults;
    }
}
