package com.github.innovationforge.web.controller;

import com.github.innovationforge.model.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/services")
public class ServiceController {
    // ServiceController endpoints...
    @GetMapping("/{serviceId}")
    public Mono<Service> selectService(@PathVariable Long serviceId) {
        // Logic to retrieve the selected service by ID
        // Return Mono<Service> representing the selected service
        return Mono.just(Service.builder().build());
    }

    @GetMapping
    public Flux<Service> browseServices() {
        // Logic to retrieve all services
        // Return Flux<Service> representing the list of services
        return Flux.just(Service.builder().build(), Service.builder().build());
    }
}