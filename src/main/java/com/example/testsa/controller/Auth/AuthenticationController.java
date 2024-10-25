package com.example.testsa.controller.Auth;

import org.springframework.web.bind.annotation.PostMapping;

import com.example.testsa.service.AuthenticationService;

public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    @PostMapping("authenticate")
    public String authenticate(){
        return authenticationService.authenticate();
    }
}
