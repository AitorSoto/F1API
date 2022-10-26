package com.f1.records.services.status;

import com.f1.records.pojos.DAOs.StatusDAO;

import java.util.List;

public interface StatusService {
    List<StatusDAO> getAllStatuses();

    StatusDAO getById(int id);
}
