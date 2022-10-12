package com.f1.records.services.status;

import com.f1.records.pojos.DTOs.Status;

import java.util.List;

public interface StatusService {
    List<Status> getAllStatuses();

    Status getById(int id);
}
