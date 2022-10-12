package com.f1.records.pojos.DTOs;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "laptimes")
@IdClass(LapTime.class)
public class LapTime implements Serializable {
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
    private Race race;
    @OneToOne
    @JoinColumn(name = "driver_id", insertable=false, updatable=false)
    private Driver driver;

    public LapTime() {
    }

    public LapTime(int raceId, int driverId, int lap, int position, String time, int milliseconds, Race race, Driver driver) {
        this.raceId = raceId;
        this.driverId = driverId;
        this.lap = lap;
        this.position = position;
        this.time = time;
        this.milliseconds = milliseconds;
        this.race = race;
        this.driver = driver;
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

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LapTime lapTime = (LapTime) o;
        return raceId == lapTime.raceId && driverId == lapTime.driverId && lap == lapTime.lap && position == lapTime.position && milliseconds == lapTime.milliseconds && time.equals(lapTime.time) && race.equals(lapTime.race) && driver.equals(lapTime.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceId, driverId, lap, position, time, milliseconds, race, driver);
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
                ", race=" + race +
                ", driver=" + driver +
                '}';
    }
}
