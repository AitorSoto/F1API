package com.f1.records.services.constructors;

import com.f1.records.pojos.Constructor;

import java.util.List;

public interface ConstructorService {
    List<Constructor> findAllConstrucotors();
    List<Constructor> findConstructorById(int idConstructor);
}
