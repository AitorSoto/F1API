package com.f1.records.services.lapTime;

import com.f1.records.mappers.UniversalMapper;
import com.f1.records.pojos.DAOs.LapTimeDAO;
import com.f1.records.pojos.DAOs.PitStopDAO;
import com.f1.records.pojos.DTOs.LapTimeDTO;
import com.f1.records.pojos.DTOs.PitStopDTO;
import com.f1.records.repositorys.LapTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LapTimeServiceImpl implements LapTimeService{
    @Autowired
    LapTimeRepository lapTimeRepository;

    @Override
    public List<LapTimeDTO> findAllLapTimes(int pageNo, int pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<LapTimeDAO> lapTimesPageable = lapTimeRepository.findAll(paging);

        return transfromListDAOIntoListDTO(lapTimesPageable.getContent());
    }

    @Override
    public List<LapTimeDTO> findAllLapTimes(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<LapTimeDAO> lapTimesPageable = lapTimeRepository.findAll(paging);

        return transfromListDAOIntoListDTO(lapTimesPageable.getContent());
    }

    @Override
    public List<LapTimeDTO> findByDriverIdAndRaceId(int driverId, int raceId, int pageNo, int pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<LapTimeDAO> lapTimePage = lapTimeRepository.getAllLapsTimesByDriverIdAndRaceId(driverId, raceId, paging);

        return transfromListDAOIntoListDTO(lapTimePage.getContent());
    }

    @Override
    public List<LapTimeDTO> findByDriverIdAndRaceId(int driverId, int raceId, int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<LapTimeDAO> lapTimePage = lapTimeRepository.getAllLapsTimesByDriverIdAndRaceId(driverId, raceId, paging);

        return transfromListDAOIntoListDTO(lapTimePage.getContent());
    }

    private List<LapTimeDTO> transfromListDAOIntoListDTO(List<LapTimeDAO> laptimeDAOs){
        List<LapTimeDTO> laptimeDTOs = new ArrayList<>();
        for(LapTimeDAO result: laptimeDAOs){
            laptimeDTOs.add(UniversalMapper.laptimeToDTO(result));
        }
        return laptimeDTOs;
    }
}
