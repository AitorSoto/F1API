package com.f1.records.pojos.DTOs;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "races")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "race_id")
    private int raceId;
	private int year;
    private int round;
    @Column(name = "circuit_id")
    private int circuitId;
    private String name;
    private Date date;
    private Time time;
	private String url;
    private Date fp1Date;
	private Time fp1Time;
	private Date fp2Date  ;
	private Time fp2Time;
	private Date fp3Date;
	private Time fp3Time;
	private Date qualiDate;
	private Time qualiTime;
	private Date sprintDate;
	private Time sprintTime;
    @OneToOne
    @JoinColumn(name = "circuit_id", insertable = false, updatable = false)
    private Circuit circuit;

    public Race() {
    }

    public Race(int raceId, int year, int round, int circuitId, String name, Date date, Time time, String url, Date fp1Date, Time fp1Time, Date fp2Date, Time fp2Time, Date fp3Date, Time fp3Time, Date qualiDate, Time qualiTime, Date sprintDate, Time sprintTime, Circuit circuit) {
        this.raceId = raceId;
        this.year = year;
        this.round = round;
        this.circuitId = circuitId;
        this.name = name;
        this.date = date;
        this.time = time;
        this.url = url;
        this.fp1Date = fp1Date;
        this.fp1Time = fp1Time;
        this.fp2Date = fp2Date;
        this.fp2Time = fp2Time;
        this.fp3Date = fp3Date;
        this.fp3Time = fp3Time;
        this.qualiDate = qualiDate;
        this.qualiTime = qualiTime;
        this.sprintDate = sprintDate;
        this.sprintTime = sprintTime;
        this.circuit = circuit;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getCircuitId() {
        return circuitId;
    }

    public void setCircuitId(int circuitId) {
        this.circuitId = circuitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getFp1Date() {
        return fp1Date;
    }

    public void setFp1Date(Date fp1Date) {
        this.fp1Date = fp1Date;
    }

    public Time getFp1Time() {
        return fp1Time;
    }

    public void setFp1Time(Time fp1Time) {
        this.fp1Time = fp1Time;
    }

    public Date getFp2Date() {
        return fp2Date;
    }

    public void setFp2Date(Date fp2Date) {
        this.fp2Date = fp2Date;
    }

    public Time getFp2Time() {
        return fp2Time;
    }

    public void setFp2Time(Time fp2Time) {
        this.fp2Time = fp2Time;
    }

    public Date getFp3Date() {
        return fp3Date;
    }

    public void setFp3Date(Date fp3Date) {
        this.fp3Date = fp3Date;
    }

    public Time getFp3Time() {
        return fp3Time;
    }

    public void setFp3Time(Time fp3Time) {
        this.fp3Time = fp3Time;
    }

    public Date getQualiDate() {
        return qualiDate;
    }

    public void setQualiDate(Date qualiDate) {
        this.qualiDate = qualiDate;
    }

    public Time getQualiTime() {
        return qualiTime;
    }

    public void setQualiTime(Time qualiTime) {
        this.qualiTime = qualiTime;
    }

    public Date getSprintDate() {
        return sprintDate;
    }

    public void setSprintDate(Date sprintDate) {
        this.sprintDate = sprintDate;
    }

    public Time getSprintTime() {
        return sprintTime;
    }

    public void setSprintTime(Time sprintTime) {
        this.sprintTime = sprintTime;
    }

    public Circuit getCircuit() {
        return circuit;
    }

    public void setCircuit(Circuit circuit) {
        this.circuit = circuit;
    }

    @Override
    public String toString() {
        return "Race{" +
                "raceId=" + raceId +
                ", year=" + year +
                ", round=" + round +
                ", circuitId=" + circuitId +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", url='" + url + '\'' +
                ", fp1Date=" + fp1Date +
                ", fp1Time=" + fp1Time +
                ", fp2Date=" + fp2Date +
                ", fp2Time=" + fp2Time +
                ", fp3Date=" + fp3Date +
                ", fp3Time=" + fp3Time +
                ", qualiDate=" + qualiDate +
                ", qualiTime=" + qualiTime +
                ", sprintDate=" + sprintDate +
                ", sprintTime=" + sprintTime +
                ", circuit=" + circuit +
                '}';
    }
}
