package com.f1.records.services.constructors;

import com.f1.records.pojos.DTOs.Constructor;
import com.f1.records.repositorys.ConstructorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConstructorServiceImpl implements ConstructorService{
    @Autowired
    ConstructorsRepository constructorRepository;

    @Override
    public List<Constructor> findAllConstrucotors() {
        Iterable<Constructor> optionalResults = constructorRepository.findAll();
        List<Constructor> constructorResults = new ArrayList<>();
        optionalResults.forEach(constructorResults::add);
        return constructorResults;
    }

    @Override
    public List<Constructor> findConstructorById(int idConstructor) {
        Iterable<Constructor> optionalResults = constructorRepository.findAll();
        List<Constructor> constructorResults = new ArrayList<>();
        optionalResults.forEach(constructorResults::add);
        List<Constructor> filteredConstructorResults =
                constructorResults.stream()
                        .filter(constructor -> constructor.getConstructorId() == idConstructor)
                        .collect(Collectors.toList());
        return filteredConstructorResults;
    }
}
