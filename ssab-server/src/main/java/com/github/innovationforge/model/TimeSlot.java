package com.github.innovationforge.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TimeSlot {
    private Long id;
    private Date startTime;
    private Date endTime;
}
