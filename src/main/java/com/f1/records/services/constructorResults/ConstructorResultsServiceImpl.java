package com.f1.records.services.constructorResults;

import com.f1.records.pojos.DAOs.ConstructorResultDAO;
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
    public List<ConstructorResultDAO> getAllConstructorResults() {
        Iterable<ConstructorResultDAO> optionalResults = constructorRespository.findAll();
        List<ConstructorResultDAO> constructorResultDAOS = new ArrayList<>();
        optionalResults.forEach(constructorResultDAOS::add);
        return constructorResultDAOS;
    }

    @Override
    public List<ConstructorResultDAO> getAllConstructorResultsById(int idConstructor) {
        Iterable<ConstructorResultDAO> optionalResults = constructorRespository.findAll();
        List<ConstructorResultDAO> constructorResultDAOS = new ArrayList<>();
        optionalResults.forEach(constructorResultDAOS::add);
        List<ConstructorResultDAO> filteredConstructorResultDAOS =
                constructorResultDAOS.stream()
                .filter(constructor -> constructor.getConstructorId() == idConstructor)
                .collect(Collectors.toList());
        return filteredConstructorResultDAOS;
    }
}
