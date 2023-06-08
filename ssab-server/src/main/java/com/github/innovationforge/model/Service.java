package com.github.innovationforge.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Service {
    private Long id;
    private String name;
    private String description;
    private double price;
}
