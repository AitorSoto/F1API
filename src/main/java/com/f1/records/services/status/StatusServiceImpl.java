package com.f1.records.services.status;

import com.f1.records.pojos.DAOs.StatusDAO;
import com.f1.records.repositorys.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    StatusRepository statusRepository;

    @Override
    public List<StatusDAO> getAllStatuses() {
        Iterable<StatusDAO> iterator = statusRepository.findAll();
        List<StatusDAO> statusDAOS = new ArrayList<>();
        iterator.forEach(statusDAOS::add);
        return statusDAOS;
    }

    @Override
    public StatusDAO getById(int id) {
        Optional<StatusDAO> statusOptional = statusRepository.findById(id);
        StatusDAO statusDAO = statusOptional.get();
        return statusDAO;
    }
}
