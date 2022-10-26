package com.f1.records.services.constructors;

import com.f1.records.pojos.DAOs.ConstructorDAO;
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
    public List<ConstructorDAO> findAllConstrucotors() {
        Iterable<ConstructorDAO> optionalResults = constructorRepository.findAll();
        List<ConstructorDAO> constructorDAOResults = new ArrayList<>();
        optionalResults.forEach(constructorDAOResults::add);
        return constructorDAOResults;
    }

    @Override
    public List<ConstructorDAO> findConstructorById(int idConstructor) {
        Iterable<ConstructorDAO> optionalResults = constructorRepository.findAll();
        List<ConstructorDAO> constructorDAOResults = new ArrayList<>();
        optionalResults.forEach(constructorDAOResults::add);
        List<ConstructorDAO> filteredConstructorResultDTOS =
                constructorDAOResults.stream()
                        .filter(constructor -> constructor.getConstructorId() == idConstructor)
                        .collect(Collectors.toList());
        return filteredConstructorResultDTOS;
    }
}
