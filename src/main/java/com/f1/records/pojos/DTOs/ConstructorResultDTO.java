package com.f1.records.pojos.DTOs;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ConstructorResultDTO {
    private int raceId;
    private int constructorId;
    private String raceName;
    private int raceYear;
    private String constructorName;
    private float points;
    private String status;
}
