package com.f1.records.services.constructors;

import com.f1.records.mappers.UniversalMapper;
import com.f1.records.pojos.DAOs.ConstructorDAO;
import com.f1.records.pojos.DTOs.ConstructorDTO;;
import com.f1.records.repositorys.ConstructorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ConstructorServiceImpl implements ConstructorService{
    @Autowired
    ConstructorsRepository constructorRepository;

    @Override
    public List<ConstructorDTO> findAllConstructors(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<ConstructorDAO> pages = constructorRepository.findAll(pageable);
        return transformListDAOIntoListDTO(pages.getContent());
    }

    @Override
    public List<ConstructorDTO> findAllConstructors(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<ConstructorDAO> pages = constructorRepository.findAll(pageable);
        return transformListDAOIntoListDTO(pages.getContent());
    }

    @Override
    public ConstructorDTO findConstructorByName(String constructorName) {
        ConstructorDAO constructorDAO = constructorRepository.findConstructorByName(constructorName);
        return UniversalMapper.constructorToDTO(constructorDAO);
    }

    @Override
    public ConstructorDTO findConstructorById(int idConstructor) {
        ConstructorDAO constructorDAO = constructorRepository.findConstructorByConstructorId(idConstructor);
        return UniversalMapper.constructorToDTO(constructorDAO);
    }

    @Override
    public List<String> findAllConstructorsByDriverId(int driverId) {
        return constructorRepository.findConstructorsOfId(driverId);
    }

    private List<ConstructorDTO> transformListDAOIntoListDTO(List<ConstructorDAO> constructorsDAo){
        List<ConstructorDTO> constructorsDTO = new ArrayList<>();
        for(ConstructorDAO result: constructorsDAo){
            constructorsDTO.add(UniversalMapper.constructorToDTO(result));
        }
        return constructorsDTO;
    }
}
