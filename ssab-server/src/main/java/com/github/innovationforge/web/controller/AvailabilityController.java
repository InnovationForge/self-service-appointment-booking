package com.github.innovationforge.web.controller;

import com.github.innovationforge.model.TimeSlot;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/services")
public class AvailabilityController {
    // AvailabilityController endpoints...
    @GetMapping("/{serviceId}/availability")
    public Flux<TimeSlot> checkAvailability(@PathVariable Long serviceId, @RequestParam("date") String selectedDate) {
        // Logic to check availability for the given service and date
        // Return Flux<TimeSlot> representing the available time slots
        return Flux.just(TimeSlot.builder().build(), TimeSlot.builder().build());
    }
}