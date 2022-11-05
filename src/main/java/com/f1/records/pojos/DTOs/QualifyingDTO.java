package com.f1.records.pojos.DTOs;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QualifyingDTO {
    private int qualifyId;
    private int raceId;
    private int driverId;
    private int constructorId;
    private int number;
    private int position;
    private int year;
    private String q1;
    private String q2;
    private String q3;
    private String raceName;
    private String driverSurname;
    private String driverForename;
    private String driverCode;
    private String driverNationality;
    private String constructorName;
    private String constructorNationality;
}
