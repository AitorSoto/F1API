package com.f1.records.pojos.DTOs;

import javax.persistence.*;

@Entity
@Table(name = "constructorstandings")
public class ConstructorStanding {
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
    private Constructor constructor;
    @OneToOne
    @JoinColumn(name = "race_id", insertable=false, updatable=false)
    private Race race;

    public ConstructorStanding() {
    }

    public ConstructorStanding(int constructorStandingsId, int raceId, int constructorId, float points, int position, String positionText, int wins, Constructor constructor, Race race) {
        this.constructorStandingsId = constructorStandingsId;
        this.raceId = raceId;
        this.constructorId = constructorId;
        this.points = points;
        this.position = position;
        this.positionText = positionText;
        this.wins = wins;
        this.constructor = constructor;
        this.race = race;
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

    public Constructor getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
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
                ", constructor=" + constructor +
                ", race=" + race +
                '}';
    }
}
