package com.github.innovationforge.web.controller;

import com.github.innovationforge.model.User;
import com.github.innovationforge.web.dto.LoginRequest;
import com.github.innovationforge.web.dto.LoginResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
public class UserController {
    // UserController endpoints...
    @PostMapping("/login")
    public Mono<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest) {
        // Logic to authenticate the user
        // Return Mono<LoginResponse> representing the login response
        return Mono.just(LoginResponse.builder().build());
    }

    @PostMapping("/register")
    public Mono<User> registerUser(@RequestBody User user) {
        // Logic to register the user
        // Return Mono<User> representing the registered user
        return Mono.just(User.builder().build());
    }
}