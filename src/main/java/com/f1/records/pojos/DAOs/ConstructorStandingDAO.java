package com.f1.records.pojos.DAOs;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "constructorstandings")
public class ConstructorStandingDAO implements Serializable {
    @Id
    private int constructorStandingsId;
    @Column(name = "race_id")
    private int raceId;
    @Column(name = "constructor_id")
    private int constructorId;
    private float points;
    private int position;
    private String positionText;
    private int wins;
    @OneToOne
    @JoinColumn(name = "constructor_id", insertable=false, updatable=false)
    private ConstructorDAO constructorDAO;
    @OneToOne
    @JoinColumn(name = "race_id", insertable=false, updatable=false)
    private RaceDAO raceDAO;

    public ConstructorStandingDAO() {
    }

    public ConstructorStandingDAO(int constructorStandingsId, int raceId, int constructorId, float points, int position, String positionText, int wins, ConstructorDAO constructorDAO, RaceDAO raceDAO) {
        this.constructorStandingsId = constructorStandingsId;
        this.raceId = raceId;
        this.constructorId = constructorId;
        this.points = points;
        this.position = position;
        this.positionText = positionText;
        this.wins = wins;
        this.constructorDAO = constructorDAO;
        this.raceDAO = raceDAO;
    }

    public int getConstructorStandingsId() {
        return constructorStandingsId;
    }

    public void setConstructorStandingsId(int constructorStandingsId) {
        this.constructorStandingsId = constructorStandingsId;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public int getConstructorId() {
        return constructorId;
    }

    public void setConstructorId(int constructorId) {
        this.constructorId = constructorId;
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

    public ConstructorDAO getConstructor() {
        return constructorDAO;
    }

    public void setConstructor(ConstructorDAO constructorDAO) {
        this.constructorDAO = constructorDAO;
    }

    public RaceDAO getRace() {
        return raceDAO;
    }

    public void setRace(RaceDAO raceDAO) {
        this.raceDAO = raceDAO;
    }

    @Override
    public String toString() {
        return "ConstructorStanding{" +
                "constructorStandingsId=" + constructorStandingsId +
                ", raceId=" + raceId +
                ", constructorId=" + constructorId +
                ", points=" + points +
                ", position=" + position +
                ", positionText='" + positionText + '\'' +
                ", wins=" + wins +
                ", constructor=" + constructorDAO +
                ", race=" + raceDAO +
                '}';
    }
}
