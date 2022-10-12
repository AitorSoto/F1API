package com.f1.records.pojos.DTOs;

import javax.persistence.*;

@Entity
@Table(name = "qualifying")
public class Qualifying {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qualify_id")
    private int qualifyId;
    @Column(name = "race_id")
    private int raceId;
    @Column(name = "driver_id")
    private int driverId;
    @Column(name = "constructor_id")
    private int constructorId;
    private int number;
    private int position;
    private String q1;
    private String q2;
    private String q3;
    @OneToOne
    @JoinColumn(name = "race_id", insertable=false, updatable=false)
    private Race race;
    @OneToOne
    @JoinColumn(name = "driver_id", insertable=false, updatable=false)
    private Driver driver;
    @OneToOne
    @JoinColumn(name = "constructor_id", insertable=false, updatable=false)
    private Constructor constructor;

    public Qualifying() {
    }

    public Qualifying(int qualifyId, int raceId, int driverId, int constructorId, int number, int position, String q1, String q2, String q3, Race race, Driver driver, Constructor constructor) {
        this.qualifyId = qualifyId;
        this.raceId = raceId;
        this.driverId = driverId;
        this.constructorId = constructorId;
        this.number = number;
        this.position = position;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
        this.race = race;
        this.driver = driver;
        this.constructor = constructor;
    }

    public int getQualifyId() {
        return qualifyId;
    }

    public void setQualifyId(int qualifyId) {
        this.qualifyId = qualifyId;
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

    public int getConstructorId() {
        return constructorId;
    }

    public void setConstructorId(int constructorId) {
        this.constructorId = constructorId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public String getQ3() {
        return q3;
    }

    public void setQ3(String q3) {
        this.q3 = q3;
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

    public Constructor getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
    }

    @Override
    public String toString() {
        return "Qualifying{" +
                "qualifyId=" + qualifyId +
                ", raceId=" + raceId +
                ", driverId=" + driverId +
                ", constructorId=" + constructorId +
                ", number=" + number +
                ", position=" + position +
                ", q1='" + q1 + '\'' +
                ", q2='" + q2 + '\'' +
                ", q3='" + q3 + '\'' +
                ", race=" + race +
                ", driver=" + driver +
                ", constructor=" + constructor +
                '}';
    }
}
