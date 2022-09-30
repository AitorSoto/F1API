package com.f1.records.pojos;

import javax.persistence.*;

@Entity
@Table(name = "driverstandings")
public class DriverStanding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driverStandingsId;
    private int raceId;
    private int driverId;
    private float points;
    private int position;
    private String positionText;
    private int wins;

    public DriverStanding() {
    }

    public DriverStanding(int driverStandingsId, int raceId, int driverId, float points, int position, String positionText, int wins) {
        this.driverStandingsId = driverStandingsId;
        this.raceId = raceId;
        this.driverId = driverId;
        this.points = points;
        this.position = position;
        this.positionText = positionText;
        this.wins = wins;
    }

    public int getDriverStandingsId() {
        return driverStandingsId;
    }

    public void setDriverStandingsId(int driverStandingsId) {
        this.driverStandingsId = driverStandingsId;
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

    public float getPoints() {
        return points;
    }

    public void setPoints(float points) {
        this.points = points;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getPositionText() {
        return positionText;
    }

    public void setPositionText(String positionText) {
        this.positionText = positionText;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    @Override
    public String toString() {
        return "DriverStanding{" +
                "driverStandingsId=" + driverStandingsId +
                ", raceId=" + raceId +
                ", driverId=" + driverId +
                ", points=" + points +
                ", position=" + position +
                ", positionText='" + positionText + '\'' +
                ", wins=" + wins +
                '}';
    }
}
