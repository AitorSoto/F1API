package com.f1.records.pojos.DAOs;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "constructorresults")
public class ConstructorResultDAO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "constructor_results_id")
    private int constructorResultId;
    private int raceId;
    private int constructorId;
    private float points;
    private String status;
    @OneToOne
    @JoinColumn(name = "raceId", referencedColumnName = "race_id", insertable=false, updatable=false)
    private RaceDAO race;
    @OneToOne
    @JoinColumn(name = "constructorId", referencedColumnName = "constructor_id", insertable=false, updatable=false)
    private ConstructorDAO constructor;

    public ConstructorResultDAO() {
    }

    public ConstructorResultDAO(int constructorResultId, int raceId, int constructorId, float points, String status, RaceDAO race, ConstructorDAO constructor) {
        this.constructorResultId = constructorResultId;
        this.raceId = raceId;
        this.constructorId = constructorId;
        this.points = points;
        this.status = status;
        this.race = race;
        this.constructor = constructor;
    }

    public int getConstructorResultId() {
        return constructorResultId;
    }

    public void setConstructorResultId(int constructorResultId) {
        this.constructorResultId = constructorResultId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RaceDAO getRace() {
        return race;
    }

    public void setRace(RaceDAO race) {
        this.race = race;
    }

    public ConstructorDAO getConstructor() {
        return constructor;
    }

    public void setConstructor(ConstructorDAO constructor) {
        this.constructor = constructor;
    }

    @Override
    public String toString() {
        return "ConstructorResultDAO{" +
                "constructorResultId=" + constructorResultId +
                ", raceId=" + raceId +
                ", constructorId=" + constructorId +
                ", points=" + points +
                ", status='" + status + '\'' +
                ", race=" + race +
                ", constructor=" + constructor +
                '}';
    }
}

