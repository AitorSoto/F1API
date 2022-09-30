package com.f1.records.pojos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "constructorstandings")
public class ConstructorStanding {
    @Id
    private int constructorStandingsId;
    private int raceId;
    private int constructorId;
    private float points;
    private int position;
    private String positionText;
    private int wins;

    public ConstructorStanding() {
    }

    public ConstructorStanding(int constructorStandingsId, int raceId, int constructorId, float points, int position, String positionText, int wins) {
        this.constructorStandingsId = constructorStandingsId;
        this.raceId = raceId;
        this.constructorId = constructorId;
        this.points = points;
        this.position = position;
        this.positionText = positionText;
        this.wins = wins;
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

    @Override
    public String toString() {
        return "ConstructorStandings{" +
                "constructorStandingwId=" + constructorStandingsId +
                ", raceId=" + raceId +
                ", constructorId=" + constructorId +
                ", points=" + points +
                ", position=" + position +
                ", positionText='" + positionText + '\'' +
                ", wins=" + wins +
                '}';
    }
}
