package com.github.innovationforge.web.controller;

import com.github.innovationforge.model.Appointment;
import com.github.innovationforge.web.dto.AppointmentRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @PutMapping("/{appointmentId}")
    public Mono<Appointment> rescheduleAppointment(@PathVariable Long appointmentId, @RequestBody AppointmentRequest appointmentRequest) {
        // Logic to reschedule or cancel the appointment
        // Return Mono<Appointment> representing the updated appointment
        return Mono.just(Appointment.builder().build());
    }

    @GetMapping
    public Flux<Appointment> viewUpcomingAppointments(@RequestParam("userId") Long userId) {
        // Logic to retrieve upcoming appointments for the specified user
        // Return Flux<Appointment> representing the list of upcoming appointments
        return Flux.just(Appointment.builder().build(), Appointment.builder().build());
    }

    @PostMapping
    public Mono<Appointment> bookAppointment(@RequestBody AppointmentRequest appointmentRequest) {
        // Logic to book the appointment
        // Return Mono<Appointment> representing the booked appointment
        return Mono.just(Appointment.builder().build());
    }
}