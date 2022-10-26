package com.f1.records.pojos.DTOs;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ConstructorStandingDTO {
    private int raceId;
    private int constructorId;
    private float points;
    private int position;
    private int wins;
    private String constructorName;
    private String raceName;
}
