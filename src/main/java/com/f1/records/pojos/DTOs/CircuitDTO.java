package com.f1.records.pojos.DTOs;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CircuitDTO {
    private int circuitId;
    private String circuitRef;
    private String name;
    private String location;
    private String country;
}
