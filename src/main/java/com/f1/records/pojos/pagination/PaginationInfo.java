package com.f1.records.pojos.pagination;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaginationInfo {
    private boolean hasNext;
    private int currentPage;
    private int numberOfPages;
}
