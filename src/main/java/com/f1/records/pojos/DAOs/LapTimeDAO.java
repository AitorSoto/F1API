package com.f1.records.pojos.DAOs;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import com.f1.records.pojos.DTOs.RaceDTO;

@Entity
@Table(name = "laptimes")
@IdClass(LapTimeDAO.class)
public class LapTimeDAO implements Serializable {
    @Id
    @Column(name = "race_id")
    private int raceId;
    @Id
    @Column(name = "driver_id")
    private int driverId;
    @Id
    @Column(name = "lap")
    private int lap;
    private int position;
    private String time;
    private int milliseconds;
    @OneToOne
    @JoinColumn(name = "race_id", insertable=false, updatable=false)
    private RaceDAO raceDAO;
    @OneToOne
    @JoinColumn(name = "driver_id", insertable=false, updatable=false)
    private DriverDAO driverDAO;

    public LapTimeDAO() {
    }

    public LapTimeDAO(int raceId, int driverId, int lap, int position, String time, int milliseconds, RaceDAO raceDAO, DriverDAO driverDAO) {
        this.raceId = raceId;
        this.driverId = driverId;
        this.lap = lap;
        this.position = position;
        this.time = time;
        this.milliseconds = milliseconds;
        this.raceDAO = raceDAO;
        this.driverDAO = driverDAO;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public int getLap() {
        return lap;
    }

    public void setLap(int lap) {
        this.lap = lap;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(int milliseconds) {
        this.milliseconds = milliseconds;
    }

    public RaceDAO getRace() {
        return raceDAO;
    }

    public void setRace(RaceDAO raceDAO) {
        this.raceDAO = raceDAO;
    }

    public DriverDAO getDriver() {
        return driverDAO;
    }

    public void setDriver(DriverDAO driverDAO) {
        this.driverDAO = driverDAO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LapTimeDAO lapTimeDAO = (LapTimeDAO) o;
        return raceId == lapTimeDAO.raceId && driverId == lapTimeDAO.driverId && lap == lapTimeDAO.lap && position == lapTimeDAO.position && milliseconds == lapTimeDAO.milliseconds && time.equals(lapTimeDAO.time) && raceDAO.equals(lapTimeDAO.raceDAO) && driverDAO.equals(lapTimeDAO.driverDAO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceId, driverId, lap, position, time, milliseconds, raceDAO, driverDAO);
    }

    @Override
    public String toString() {
        return "LapTime{" +
                "raceId=" + raceId +
                ", driverId=" + driverId +
                ", lap=" + lap +
                ", position=" + position +
                ", time='" + time + '\'' +
                ", milliseconds=" + milliseconds +
                ", race=" + raceDAO +
                ", driver=" + driverDAO +
                '}';
    }
}
