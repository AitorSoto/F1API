package com.f1.records.services.circuit;

import com.f1.records.pojos.DAOs.CircuitDAO;
import com.f1.records.repositorys.CircuitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CircuitServiceImpl implements CircuitService{
    @Autowired
    CircuitRepository circuitRepository;

    @Override
    public List<CircuitDAO> getAllCircuits(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<CircuitDAO> circuits = circuitRepository.findAll(pageable);

        return circuits.getContent();
    }

    @Override
    public List<CircuitDAO> getAllCircuits(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<CircuitDAO> circuits = circuitRepository.findAll(pageable);

        return circuits.getContent();
    }

    @Override
    public CircuitDAO getCircuitById(int id) {
        Optional<CircuitDAO> circuitOptional = circuitRepository.findById(id);
        CircuitDAO circuitDAO = circuitOptional.get();
        return circuitDAO;
    }

    @Override
    public CircuitDAO getCircuitByName(String name) {
        return null;
    }
}
