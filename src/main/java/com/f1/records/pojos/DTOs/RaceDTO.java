package com.f1.records.pojos.DTOs;

import lombok.*;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RaceDTO {
    private int raceId;
    private int year;
    private int round;
    private int circuitId;
    private String circuitName;
    private String circuitLocation;
    private String circuitCountry;
    private String raceName;
    private Date fp1Date;
    private Time fp1Time;
    private Date fp2Date;
    private Time fp2Time;
    private Date fp3Date;
    private Time fp3Time;
    private Date qualiDate;
    private Time qualiTime;
    private Date sprintDate;
    private Time sprintTime;
}
