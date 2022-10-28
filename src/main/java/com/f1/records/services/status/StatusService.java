package com.f1.records.services.status;

import com.f1.records.pojos.DTOs.StatusDTO;
import com.f1.records.pojos.DTOs.StatusDTO;

import java.util.List;

public interface StatusService {
    List<StatusDTO> getAllStatuses(int pageNo, int pageSize);
    StatusDTO getById(int id);
}
