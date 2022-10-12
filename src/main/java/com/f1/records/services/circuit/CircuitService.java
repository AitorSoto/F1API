package com.f1.records.services.circuit;

import com.f1.records.pojos.DTOs.Circuit;

import java.util.List;

public interface CircuitService {
    List<Circuit> getAllCircuits();
    Circuit getCircuitById(int id);
}
