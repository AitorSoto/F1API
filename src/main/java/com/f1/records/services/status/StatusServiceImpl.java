package com.f1.records.services.status;

import com.f1.records.pojos.Status;
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
    public List<Status> getAllStatuses() {
        Iterable<Status> iterator = statusRepository.findAll();
        List<Status> statuses = new ArrayList<>();
        iterator.forEach(statuses::add);
        return statuses;
    }

    @Override
    public Status getById(int id) {
        Optional<Status> statusOptional = statusRepository.findById(id);
        Status status = statusOptional.get();
        return status;
    }
}
