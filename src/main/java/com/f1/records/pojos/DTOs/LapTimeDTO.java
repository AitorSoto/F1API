package com.f1.records.pojos.DTOs;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LapTimeDTO {
    private int raceId;
    private int driverId;
    private int lap;
    private int position;
    private String time;
    private int milliseconds;
    private String raceName;
    private int raceYear;
    private String driverSurname;
    private String driverForename;
    private String driverCode;
    private String driverNationality;
}
