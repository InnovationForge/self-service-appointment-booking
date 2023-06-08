package com.github.innovationforge.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Appointment {
    private Long id;
    private Long userId;
    private Long serviceId;
    private Date date;
    private Long timeSlotId;
    private String notes;
}
