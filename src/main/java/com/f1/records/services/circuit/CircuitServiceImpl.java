package com.f1.records.services.circuit;

import com.f1.records.pojos.DTOs.Circuit;
import com.f1.records.repositorys.CircuitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CircuitServiceImpl implements CircuitService{
    @Autowired
    CircuitRepository circuitRepository;

    @Override
    public List<Circuit> getAllCircuits() {
        Iterable<Circuit> circuitIterator = circuitRepository.findAll();
        List<Circuit> circuits = new ArrayList<>();
        circuitIterator.forEach(circuits::add);

        return circuits;
    }

    @Override
    public Circuit getCircuitById(int id) {
        Optional<Circuit> circuitOptional = circuitRepository.findById(id);
        Circuit circuit = circuitOptional.get();
        return circuit;
    }
}
