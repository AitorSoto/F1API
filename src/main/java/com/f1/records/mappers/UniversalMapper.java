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
        qualifyingDTO.setYear(qDAO.getRace().getYear());
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

    public static LapTimeDTO laptimeToDTO(LapTimeDAO laptimeDAO){
        LapTimeDTO lapTimeDTO = new LapTimeDTO();
        lapTimeDTO.setRaceId(laptimeDAO.getRaceId());
        lapTimeDTO.setDriverId(laptimeDAO.getDriverId());
        lapTimeDTO.setLap(laptimeDAO.getLap());
        lapTimeDTO.setPosition(laptimeDAO.getPosition());
        lapTimeDTO.setTime(laptimeDAO.getTime());
        lapTimeDTO.setMilliseconds(laptimeDAO.getMilliseconds());
        lapTimeDTO.setRaceName(laptimeDAO.getRace().getName());
        lapTimeDTO.setRaceYear(laptimeDAO.getRace().getYear());
        lapTimeDTO.setDriverSurname(laptimeDAO.getDriver().getSurname());
        lapTimeDTO.setDriverForename(laptimeDAO.getDriver().getForename());
        lapTimeDTO.setDriverNationality(laptimeDAO.getDriver().getNationality());
        lapTimeDTO.setDriverCode(laptimeDAO.getDriver().getCode());

        return lapTimeDTO;
    }

    public static DriverStandingDTO driverStandingToDTO(DriverStandingDAO driverStandingDAO){
        DriverStandingDTO driverStandingDTO = new DriverStandingDTO();
        driverStandingDTO.setDriverStandingId(driverStandingDAO.getDriverStandingsId());
        driverStandingDTO.setRaceId(driverStandingDAO.getRaceId());
        driverStandingDTO.setDriverId(driverStandingDAO.getDriverId());
        driverStandingDTO.setPosition(driverStandingDAO.getPosition());
        driverStandingDTO.setPoints(driverStandingDAO.getPoints());
        driverStandingDTO.setWins(driverStandingDAO.getWins());
        driverStandingDTO.setDriverForeame(driverStandingDAO.getDriver().getForename());
        driverStandingDTO.setDriverSurname(driverStandingDAO.getDriver().getSurname());
        driverStandingDTO.setDriverCode(driverStandingDAO.getDriver().getCode());
        driverStandingDTO.setDriverNationality(driverStandingDAO.getDriver().getNationality());
        driverStandingDTO.setRaceName(driverStandingDAO.getRace().getName());
        driverStandingDTO.setRaceYear(driverStandingDAO.getRace().getYear());

        return driverStandingDTO;
    }

    public static DriverDTO driverToDTO(DriverDAO driverDAO){
        DriverDTO driverDTO = new DriverDTO();
        driverDTO.setDriverId(driverDAO.getDriverId());
        driverDTO.setDriverRef(driverDAO.getDriverRef());
        driverDTO.setNumber(driverDAO.getNumber());
        driverDTO.setCode(driverDAO.getCode());
        driverDTO.setForename(driverDAO.getForename());
        driverDTO.setSurname(driverDAO.getSurname());
        driverDTO.setNationality(driverDAO.getNationality());

        return driverDTO;
    }

    public static ConstructorStandingDTO constructorStandingToDTO(ConstructorStandingDAO constructorStandingDAO){
        ConstructorStandingDTO constructorStandingDTO = new ConstructorStandingDTO();
        constructorStandingDTO.setRaceId(constructorStandingDAO.getRaceId());
        constructorStandingDTO.setConstructorId(constructorStandingDAO.getConstructorId());
        constructorStandingDTO.setPoints(constructorStandingDAO.getPoints());
        constructorStandingDTO.setPosition(constructorStandingDAO.getPosition());
        constructorStandingDTO.setWins(constructorStandingDAO.getWins());
        constructorStandingDTO.setConstructorName(constructorStandingDAO.getConstructor().getName());
        constructorStandingDTO.setConstructorNationality(constructorStandingDAO.getConstructor().getNationality());
        constructorStandingDTO.setRaceName(constructorStandingDAO.getRace().getName());
        constructorStandingDTO.setRaceYear(constructorStandingDAO.getRace().getYear());

        return constructorStandingDTO;
    }

    public static ConstructorResultDTO constructorResultToDTO(ConstructorResultDAO constructorResultDAO){
        ConstructorResultDTO constructorResultDTO = new ConstructorResultDTO();
        constructorResultDTO.setRaceId(constructorResultDAO.getRaceId());
        constructorResultDTO.setConstructorId(constructorResultDAO.getConstructorId());
        constructorResultDTO.setRaceName(constructorResultDAO.getRace().getName());
        constructorResultDTO.setRaceYear(constructorResultDAO.getRace().getYear());
        constructorResultDTO.setConstructorName(constructorResultDAO.getConstructor().getName());
        constructorResultDTO.setPoints(constructorResultDAO.getPoints());
        if(constructorResultDAO.getStatus() == null)
            constructorResultDTO.setStatus("Unknown");
        else
            constructorResultDTO.setStatus(constructorResultDAO.getStatus());

        return constructorResultDTO;
    }

    public static ConstructorDTO constructorToDTO(ConstructorDAO constructorDAO){
        ConstructorDTO constructorDTO = new ConstructorDTO();
        constructorDTO.setConstructorId(constructorDAO.getConstructorId());
        constructorDTO.setConstructorRef(constructorDAO.getConstructorRef());
        constructorDTO.setName(constructorDAO.getName());
        constructorDTO.setNationality(constructorDAO.getNationality());

        return constructorDTO;
    }

    public static CircuitDTO circuitToDTO(CircuitDAO circuitDAO){
        CircuitDTO circuitDTO = new CircuitDTO();
        circuitDTO.setCircuitId(circuitDAO.getCircuitId());
        circuitDTO.setCircuitRef(circuitDAO.getCircuitRef());
        circuitDTO.setName(circuitDAO.getName());
        circuitDTO.setLocation(circuitDAO.getLocation());
        circuitDTO.setCountry(circuitDAO.getCountry());

        return circuitDTO;
    }

    public static RaceDTO raceToDTO(RaceDAO raceDAO){
        RaceDTO raceDTO = new RaceDTO();
        raceDTO.setRaceId(raceDAO.getRaceId());
        raceDTO.setYear(raceDAO.getYear());
        raceDTO.setRound(raceDAO.getRound());
        raceDTO.setCircuitId(raceDAO.getCircuitId());
        raceDTO.setCircuitName(raceDAO.getCircuit().getName());
        raceDTO.setCircuitLocation(raceDAO.getCircuit().getLocation());
        raceDTO.setCircuitCountry(raceDAO.getCircuit().getCountry());
        raceDTO.setRaceName(raceDAO.getName());
        raceDTO.setFp1Date(raceDAO.getFp1Date());
        raceDTO.setFp1Time(raceDAO.getFp1Time());
        raceDTO.setFp2Date(raceDAO.getFp2Date());
        raceDTO.setFp2Time(raceDAO.getFp2Time());
        raceDTO.setFp3Date(raceDAO.getFp3Date());
        raceDTO.setFp3Time(raceDAO.getFp3Time());
        raceDTO.setQualiDate(raceDAO.getQualiDate());
        raceDTO.setQualiTime(raceDAO.getQualiTime());
        raceDTO.setSprintDate(raceDAO.getSprintDate());
        raceDTO.setSprintTime(raceDAO.getSprintTime());

        return raceDTO;
    }
}
