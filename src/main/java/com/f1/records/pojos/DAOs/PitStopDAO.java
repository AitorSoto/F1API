package com.f1.records.pojos.DAOs;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "pitstops")
@IdClass(PitStopDAO.class)
public class PitStopDAO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "race_id")
    private int raceId;
    @Id
    @Column(name = "driver_id")
    private int driverId;
    @Id
    private int stop;
    private int lap;
    private Time time;
    private String duration;
    private int milliseconds;
    @OneToOne
    @JoinColumn(name = "race_id", insertable=false, updatable=false)
    private RaceDAO raceDAO;
    @OneToOne
    @JoinColumn(name = "driver_id", insertable=false, updatable=false)
    private DriverDAO driverDAO;

    public PitStopDAO() {
    }

    public PitStopDAO(int raceId, int driverId, int stop, int lap, Time time, String duration, int milliseconds, RaceDAO raceDAO, DriverDAO driverDAO) {
        this.raceId = raceId;
        this.driverId = driverId;
        this.stop = stop;
        this.lap = lap;
        this.time = time;
        this.duration = duration;
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

    public int getStop() {
        return stop;
    }

    public void setStop(int stop) {
        this.stop = stop;
    }

    public int getLap() {
        return lap;
    }

    public void setLap(int lap) {
        this.lap = lap;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
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
        PitStopDAO pitStopDAO = (PitStopDAO) o;
        return raceId == pitStopDAO.raceId && driverId == pitStopDAO.driverId && stop == pitStopDAO.stop && lap == pitStopDAO.lap && milliseconds == pitStopDAO.milliseconds && time.equals(pitStopDAO.time) && duration.equals(pitStopDAO.duration) && raceDAO.equals(pitStopDAO.raceDAO) && driverDAO.equals(pitStopDAO.driverDAO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceId, driverId, stop, lap, time, duration, milliseconds, raceDAO, driverDAO);
    }

    @Override
    public String toString() {
        return "PitStop{" +
                "raceId=" + raceId +
                ", driverId=" + driverId +
                ", stop=" + stop +
                ", lap=" + lap +
                ", time=" + time +
                ", duration='" + duration + '\'' +
                ", milliseconds=" + milliseconds +
                ", race=" + raceDAO +
                ", driver=" + driverDAO +
                '}';
    }
}
