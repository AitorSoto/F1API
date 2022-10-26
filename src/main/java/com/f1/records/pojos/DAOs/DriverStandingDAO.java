package com.f1.records.pojos.DAOs;

import javax.persistence.*;

@Entity
@Table(name = "driverstandings")
public class DriverStandingDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int driverStandingsId;
    @Column(name = "race_id")
    private int raceId;
    @Column(name = "driver_id")
    private int driverId;
    private float points;
    private int position;
    private String positionText;
    private int wins;
    @OneToOne
    @JoinColumn(name = "driver_id", insertable=false, updatable=false)
    private DriverDAO driverDAO;
    @OneToOne
    @JoinColumn(name = "race_id", insertable=false, updatable=false)
    private RaceDAO raceDAO;

    public DriverStandingDAO() {
    }

    public DriverStandingDAO(int driverStandingsId, int raceId, int driverId, float points, int position, String positionText, int wins, RaceDAO raceDAO, DriverDAO driverDAO) {
        this.driverStandingsId = driverStandingsId;
        this.raceId = raceId;
        this.driverId = driverId;
        this.points = points;
        this.position = position;
        this.positionText = positionText;
        this.wins = wins;
        this.raceDAO = raceDAO;
        this.driverDAO = driverDAO;
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
    public String toString() {
        return "DriverStanding{" +
                "driverStandingsId=" + driverStandingsId +
                ", raceId=" + raceId +
                ", driverId=" + driverId +
                ", points=" + points +
                ", position=" + position +
                ", positionText='" + positionText + '\'' +
                ", wins=" + wins +
                ", race=" + raceDAO +
                ", driver=" + driverDAO +
                '}';
    }
}
