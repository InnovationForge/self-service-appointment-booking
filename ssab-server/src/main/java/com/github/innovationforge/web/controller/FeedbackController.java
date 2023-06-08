package com.github.innovationforge.web.controller;

import com.github.innovationforge.model.Feedback;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/appointments")
public class FeedbackController {

    @PostMapping("/{appointmentId}/feedback")
    public Mono<Void> provideFeedback(@PathVariable Long appointmentId, @RequestBody Feedback feedback) {
        // Logic to save the feedback for the specified appointment
        // Return Mono<Void> indicating the completion of the operation
        return Mono.empty();
    }
}