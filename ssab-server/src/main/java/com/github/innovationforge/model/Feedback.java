package com.github.innovationforge.model;

import lombok.Data;

@Data
public class Feedback {
    private Long id;
    private Long appointmentId;
    private int rating;
    private String comment;
}
