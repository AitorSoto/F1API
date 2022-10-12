package com.f1.records.services.pitStopService;

import com.f1.records.pojos.DTOs.PitStop;
import com.f1.records.repositorys.PitStopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PitStopServiceImpl implements PitStopService {
    @Autowired
    PitStopRepository pitStopRepository;

    @Override
    public List<PitStop> findAllPitStops(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<PitStop> pitStops = pitStopRepository.findAll(pageable);

        return pitStops.getContent();
    }

    @Override
    public List<PitStop> findAllPitStops(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<PitStop> pitStops = pitStopRepository.findAll(pageable);

        return pitStops.getContent();
    }

    @Override
    public List<PitStop> findByDriverId(int driverId, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<PitStop> pitStops = pitStopRepository.findPitStopsByDriverId(driverId, pageable);

        return pitStops.getContent();
    }

    @Override
    public List<PitStop> findByDriverId(int driverId, int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<PitStop> pitStops = pitStopRepository.findPitStopsByDriverId(driverId, pageable);

        return pitStops.getContent();
    }

    @Override
    public List<PitStop> findByDriverIdAndRaceId(int driverId, int raceId, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<PitStop> pitStops = pitStopRepository.findPitStopsByDriverIdAndRaceId(driverId, raceId, pageable);

        return pitStops.getContent();
    }

    @Override
    public List<PitStop> findByDriverIdAndRaceId(int driverId, int raceId, int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<PitStop> pitStops = pitStopRepository.findPitStopsByDriverIdAndRaceId(driverId, raceId, pageable);

        return pitStops.getContent();
    }
}
