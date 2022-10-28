package com.f1.records.mappers;

import com.f1.records.pojos.DTOs.*;
import com.f1.records.pojos.DAOs.*;


public class UniversalMapper {
    public static ResultDTO resultToDTO(ResultDAO resultDAO){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResultId(resultDAO.getResultId());
        resultDTO.setConstructorId(resultDAO.getConstructorId());
        resultDTO.setConstructorName(resultDAO.getConstructor().getName());
        resultDTO.setConstructorNationality(resultDAO.getConstructor().getNationality());
        resultDTO.setDriverId(resultDAO.getDriverId());
        resultDTO.setDriverForename(resultDAO.getDriver().getForename());
        resultDTO.setDriverSurname(resultDAO.getDriver().getSurname());
        resultDTO.setDriverCode(resultDAO.getDriver().getCode());
        resultDTO.setDriverNationality(resultDAO.getDriver().getNationality());
        resultDTO.setNumber(resultDAO.getNumber());
        resultDTO.setRaceId(resultDAO.getRaceId());
        resultDTO.setRaceYear(resultDAO.getRace().getYear());
        resultDTO.setRaceName(resultDAO.getRace().getName());
        resultDTO.setTime(resultDAO.getTime());
        resultDTO.setStatus(resultDAO.getStatus().getStatus());
        resultDTO.setFastestLap(resultDAO.getFastestLap());
        resultDTO.setFastestLapTime(resultDAO.getFastestLapTime());
        resultDTO.setFastestLapSpeed(resultDAO.getFastestLapSpeed());
        resultDTO.setPoints(resultDAO.getPoints());
        resultDTO.setPosition(resultDAO.getPosition());
        resultDTO.setPositionOrder(resultDAO.getPositionOrder());
        resultDTO.setGrid(resultDAO.getGrid());
        resultDTO.setRank(resultDAO.getRank());

        return resultDTO;
    }

    public static StatusDTO statusToDTO(StatusDAO statusDAO){
        StatusDTO sDTO = new StatusDTO();
        sDTO.setStatus(statusDAO.getStatus());
        return sDTO;
    }

    public static QualifyingDTO qualifyingToDTO(QualifyingDAO qDAO){
        QualifyingDTO qualifyingDTO = new QualifyingDTO();
        qualifyingDTO.setRaceId(qDAO.getRaceId());
        qualifyingDTO.setQualifyId(qDAO.getQualifyId());
        qualifyingDTO.setDriverId(qDAO.getDriverId());
        qualifyingDTO.setConstructorId(qDAO.getConstructorId());
        qualifyingDTO.setNumber(qDAO.getNumber());
        qualifyingDTO.setPosition(qDAO.getPosition());
        qualifyingDTO.setQ1(qDAO.getQ1());
        qualifyingDTO.setQ2(qDAO.getQ2());
        qualifyingDTO.setQ3(qDAO.getQ3());
        qualifyingDTO.setRaceName(qDAO.getRace().getName());
        qualifyingDTO.setDriverSurname(qDAO.getDriver().getSurname());
        qualifyingDTO.setDriverForename(qDAO.getDriver().getForename());
        qualifyingDTO.setDriverCode(qDAO.getDriver().getCode());
        qualifyingDTO.setDriverNationality(qDAO.getDriver().getNationality());
        qualifyingDTO.setConstructorName(qDAO.getConstructor().getName());
        qualifyingDTO.setConstructorNationality(qDAO.getConstructor().getNationality());
        return qualifyingDTO;
    }

    public static PitStopDTO pitStopToDTO(PitStopDAO pitStopDAO){
        PitStopDTO pitStopDTO = new PitStopDTO();
        pitStopDTO.setRaceId(pitStopDAO.getRaceId());
        pitStopDTO.setDriverId(pitStopDAO.getDriverId());
        pitStopDTO.setDriverCode(pitStopDAO.getDriver().getCode());
        pitStopDTO.setStop(pitStopDAO.getStop());
        pitStopDTO.setLap(pitStopDAO.getLap());
        pitStopDTO.setDuration(pitStopDAO.getDuration());
        pitStopDTO.setRaceName(pitStopDAO.getRace().getName());
        pitStopDTO.setDriverSurname(pitStopDAO.getDriver().getSurname());
        pitStopDTO.setDriverForename(pitStopDAO.getDriver().getForename());
        pitStopDTO.setDriverNationality(pitStopDAO.getDriver().getNationality());
        return pitStopDTO;
    }
}
