package com.f1.records.pojos;

import java.io.Serializable;
import java.util.Objects;

public class LapTimePK implements Serializable {
    private int driverId;
    private int lap;

    public LapTimePK() {
    }

    public LapTimePK(int driverId, int lap) {
        this.driverId = driverId;
        this.lap = lap;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LapTimePK lapTimePK = (LapTimePK) o;
        return driverId == lapTimePK.driverId && lap == lapTimePK.lap;
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverId, lap);
    }

    @Override
    public String toString() {
        return "LapTimePK{" +
                "driverId=" + driverId +
                ", lap=" + lap +
                '}';
    }
}
