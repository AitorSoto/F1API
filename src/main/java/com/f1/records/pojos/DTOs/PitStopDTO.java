package com.f1.records.pojos.DTOs;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PitStopDTO {
    private int raceId;
    private int driverId;
    private int stop;
    private int lap;
    private String duration;
    private String raceName;
    private String driverSurname;
    private String driverForename;
    private String driverCode;
    private String driverNationality;
}
