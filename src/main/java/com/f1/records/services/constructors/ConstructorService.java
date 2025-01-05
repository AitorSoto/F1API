package com.f1.records.services.constructors;


import com.f1.records.pojos.DAOs.ConstructorDAO;
import com.f1.records.pojos.DTOs.ConstructorDTO;

import java.util.List;

public interface ConstructorService {
    List<ConstructorDTO> findAllConstructors(int pageNo, int pageSize);
    List<ConstructorDTO> findAllConstructors(int pageNo, int pageSize, String sortBy);
    ConstructorDTO findConstructorByName(String constructorName);
    ConstructorDTO findConstructorById(int idConstructor);
    List<String> findAllConstructorsByDriverId(int driverId);
}
