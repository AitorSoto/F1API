package com.f1.records.services.status;

import com.f1.records.mappers.UniversalMapper;
import com.f1.records.pojos.DAOs.StatusDAO;
import com.f1.records.pojos.DTOs.StatusDTO;
import com.f1.records.repositorys.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService {

    @Autowired
    StatusRepository statusRepository;

    @Override
    public List<StatusDTO> getAllStatuses(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<StatusDAO> page = statusRepository.findAll(pageable);

        return transformListDTOIntoListDTO(page.getContent());
    }

    @Override
    public StatusDTO getById(int id) {
        Optional<StatusDAO> statusOptional = statusRepository.findById(id);
        StatusDAO statusDAO = statusOptional.get();
        return UniversalMapper.statusToDTO(statusDAO);
    }

    private List<StatusDTO> transformListDTOIntoListDTO(List<StatusDAO> statusDAOS){
        List<StatusDTO> statusDTOS = new ArrayList<>();
        for(StatusDAO result: statusDAOS){
            statusDTOS.add(UniversalMapper.statusToDTO(result));
        }
        return statusDTOS;
    }
}
