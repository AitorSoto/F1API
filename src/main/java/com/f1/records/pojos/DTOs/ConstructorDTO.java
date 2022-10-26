package com.f1.records.pojos.DTOs;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ConstructorDTO {
    private int constructorId;
    private String constructorRef;
    private String name;
    private String nationality;
}
