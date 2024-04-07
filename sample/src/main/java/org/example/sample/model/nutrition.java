package org.example.sample.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class nutrition {
    private String nutritionName;
    private int goal;
    private String metric;
    private int total;

}
