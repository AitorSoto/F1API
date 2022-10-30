package com.f1.records.services.race;

import com.f1.records.pojos.DTOs.RaceDTO;

import java.util.List;

public interface RaceService {
    List<RaceDTO> getAllRaces(int pageNo, int pageSize);
    List<RaceDTO> getAllRaces(int pageNo, int pageSize, String sortBy);
    List<RaceDTO> getRacesByYear(int pageNo, int pageSize, int year);
    List<RaceDTO> getRacesByYear(int pageNo, int pageSize, String sortBy, int year);
    RaceDTO getRacesByRoundAndYear(int round, int year);
    List<RaceDTO> getRacesByCircuit(int pageNo, int pageSize, String circuitName);
    List<RaceDTO> getRacesByCircuit(int pageNo, int pageSize, String sortBy, String circuitName);
    List<RaceDTO> getRacesByCountry(int pageNo, int pageSize, String country);
    List<RaceDTO> getRacesByCountry(int pageNo, int pageSize, String sortBy, String country);
}
