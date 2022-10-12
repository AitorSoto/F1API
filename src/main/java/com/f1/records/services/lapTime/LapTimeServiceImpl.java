package com.f1.records.services.lapTime;

import com.f1.records.pojos.DTOs.LapTime;
import com.f1.records.repositorys.LapTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LapTimeServiceImpl implements LapTimeService{
    @Autowired
    LapTimeRepository lapTimeRepository;

    @Override
    public List<LapTime> findAllLapTimes(int pageNo, int pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<LapTime> lapTimesPageable = lapTimeRepository.findAll(paging);

        return lapTimesPageable.getContent();
    }

    @Override
    public List<LapTime> findAllLapTimes(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<LapTime> lapTimesPageable = lapTimeRepository.findAll(paging);

        return lapTimesPageable.getContent();
    }

    @Override
    public List<LapTime> findByDriverIdAndRaceId(int driverId, int raceId, int pageNo, int pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<LapTime> lapTimePage = lapTimeRepository.getAllLapsTimesByDriverIdAndRaceId(driverId, raceId, paging);

        return lapTimePage.getContent();
    }

    @Override
    public List<LapTime> findByDriverIdAndRaceId(int driverId, int raceId, int pageNo, int pageSize) { // MAAAAAL
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<LapTime> lapTimePage = lapTimeRepository.getAllLapsTimesByDriverIdAndRaceId(driverId, raceId, paging);

        return lapTimePage.getContent();
    }
}
