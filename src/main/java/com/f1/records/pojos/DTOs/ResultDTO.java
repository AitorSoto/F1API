package com.f1.records.pojos.DTOs;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResultDTO {
    private int resultId;
    private int raceId;
    private int driverId;
    private int constructorId;
    private int number;
    private int grid;
    private int position;
    private int positionOrder;
    private float points;
    private String time;
    private int fastestLap;
    private int rank;
    private String fastestLapTime;
    private String fastestLapSpeed;
    private String status;
    private String raceName;
    private int raceYear;
    private String driverForeame;
    private String driverSurname;
    private String driverCode;
    private String driverNationality;
    private String constructorName;
    private String constructorNationality;
}
