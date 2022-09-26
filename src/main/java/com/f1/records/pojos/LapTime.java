package com.f1.records.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "laptimes")
public class LapTime {
    @Id
    private int raceId;
    private int driverId;
    private int lap;
    private String position;
    private String time;
    private int milliseconds;

    public LapTime() {
    }

    public LapTime(int raceId, int driverId, int lap, String position, String time, int milliseconds) {
        this.raceId = raceId;
        this.driverId = driverId;
        this.lap = lap;
        this.position = position;
        this.time = time;
        this.milliseconds = milliseconds;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
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

    @Override
    public String toString() {
        return "laptime{" +
                "raceId=" + raceId +
                ", driverId=" + driverId +
                ", lap=" + lap +
                ", position='" + position + '\'' +
                ", time=" + time +
                ", milliseconds=" + milliseconds +
                '}';
    }
}
