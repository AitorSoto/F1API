package com.f1.records.services.circuit;

import com.f1.records.mappers.UniversalMapper;
import com.f1.records.pojos.DAOs.CircuitDAO;
import com.f1.records.pojos.DTOs.CircuitDTO;
import com.f1.records.repositorys.CircuitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CircuitServiceImpl implements CircuitService{
    @Autowired
    CircuitRepository circuitRepository;

    @Override
    public List<CircuitDTO> getAllCircuits(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<CircuitDAO> circuits = circuitRepository.findAll(pageable);

        return transformListDAOIntoListDTO(circuits.getContent());
    }

    @Override
    public List<CircuitDTO> getAllCircuits(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<CircuitDAO> circuits = circuitRepository.findAll(pageable);

        return transformListDAOIntoListDTO(circuits.getContent());
    }

    @Override
    public CircuitDTO getCircuitById(int id) {
        Optional<CircuitDAO> circuitOptional = circuitRepository.findById(id);
        CircuitDAO circuitDAO = circuitOptional.get();
        return UniversalMapper.circuitToDTO(circuitDAO);
    }

    @Override
    public CircuitDTO getCircuitByName(String name) {
        CircuitDAO circuitDAO = circuitRepository.getCircuitByName(name);
        return UniversalMapper.circuitToDTO(circuitDAO);
    }

    @Override
    public List<CircuitDTO> getCircuitByCountry(String country) {
        List<CircuitDAO> circuitDAOS = circuitRepository.getCircuitsByCountry(country);
        return transformListDAOIntoListDTO(circuitDAOS);
    }

    private List<CircuitDTO> transformListDAOIntoListDTO(List<CircuitDAO> constructorResultDAOS){
        List<CircuitDTO> constructorResultDTOS = new ArrayList<>();
        for(CircuitDAO result: constructorResultDAOS){
            constructorResultDTOS.add(UniversalMapper.circuitToDTO(result));
        }
        return constructorResultDTOS;
    }
}
