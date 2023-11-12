package com.xifeng.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Condition {
    private String type;
    private Integer minPrice;
    private Integer maxPrice;
    private String name;
}
