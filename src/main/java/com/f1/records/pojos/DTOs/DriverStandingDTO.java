package com.f1.records.pojos.DTOs;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DriverStandingDTO {
    private int driverStandingId;
    private int raceId;
    private int driverId;
    private int position;
    private float points;
    private int wins;
    private String driverForeame;
    private String driverSurname;
    private String driverCode;
    private String driverNationality;
    private String raceName;
    private String raceYear;
}
