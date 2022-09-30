package com.f1.records.pojos;

import javax.persistence.*;

@Entity
@Table(name = "constructorresults")
public class ConstructorResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "constructor_results_id")
    private int constructorResultId;
    private int raceId;
    private int constructorId;
    private float points;
    private String status;

    public ConstructorResult() {
    }

    public ConstructorResult(int constructorResultId, int raceId, int constructorId, float points, String status) {
        this.constructorResultId = constructorResultId;
        this.raceId = raceId;
        this.constructorId = constructorId;
        this.points = points;
        this.status = status;
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

    @Override
    public String toString() {
        return "ConstructorResults{" +
                "constructorResultId=" + constructorResultId +
                ", raceId=" + raceId +
                ", constructorId=" + constructorId +
                ", points=" + points +
                ", status='" + status + '\'' +
                '}';
    }
}

