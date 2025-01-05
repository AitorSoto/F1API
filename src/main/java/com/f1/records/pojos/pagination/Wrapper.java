package com.f1.records.pojos.pagination;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Wrapper<T> {
    PaginationInfo paginationInfo;
    List<T> dto;
}
