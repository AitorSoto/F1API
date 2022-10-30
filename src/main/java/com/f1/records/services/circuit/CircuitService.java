package com.f1.records.services.circuit;

import com.f1.records.pojos.DTOs.CircuitDTO;

import java.util.List;

public interface CircuitService {
    List<CircuitDTO> getAllCircuits(int pageNo, int pageSize);
    List<CircuitDTO> getAllCircuits(int pageNo, int pageSize, String sortBy);
    CircuitDTO getCircuitById(int id);
    CircuitDTO getCircuitByName(String name);
    List<CircuitDTO> getCircuitByCountry(String country);
}
