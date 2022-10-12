package com.f1.records.pojos.DTOs;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "pitstops")
@IdClass(PitStop.class)
public class PitStop implements Serializable {
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
    private Race race;
    @OneToOne
    @JoinColumn(name = "driver_id", insertable=false, updatable=false)
    private Driver driver;

    public PitStop() {
    }

    public PitStop(int raceId, int driverId, int stop, int lap, Time time, String duration, int milliseconds, Race race, Driver driver) {
        this.raceId = raceId;
        this.driverId = driverId;
        this.stop = stop;
        this.lap = lap;
        this.time = time;
        this.duration = duration;
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
        PitStop pitStop = (PitStop) o;
        return raceId == pitStop.raceId && driverId == pitStop.driverId && stop == pitStop.stop && lap == pitStop.lap && milliseconds == pitStop.milliseconds && time.equals(pitStop.time) && duration.equals(pitStop.duration) && race.equals(pitStop.race) && driver.equals(pitStop.driver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceId, driverId, stop, lap, time, duration, milliseconds, race, driver);
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
                ", race=" + race +
                ", driver=" + driver +
                '}';
    }
}
