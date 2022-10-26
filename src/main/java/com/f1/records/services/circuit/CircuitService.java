package com.f1.records.services.circuit;

import com.f1.records.pojos.DAOs.CircuitDAO;

import java.util.List;

public interface CircuitService {
    List<CircuitDAO> getAllCircuits(int pageNo, int pageSize);
    List<CircuitDAO> getAllCircuits(int pageNo, int pageSize, String sortBy);
    CircuitDAO getCircuitById(int id);
    CircuitDAO getCircuitByName(String name);
}
