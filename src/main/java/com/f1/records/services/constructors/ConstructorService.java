package com.f1.records.services.constructors;


import com.f1.records.pojos.DAOs.ConstructorDAO;

import java.util.List;

public interface ConstructorService {
    List<ConstructorDAO> findAllConstrucotors();
    List<ConstructorDAO> findConstructorById(int idConstructor);
}
