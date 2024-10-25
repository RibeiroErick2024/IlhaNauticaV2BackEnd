package com.example.testsa.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    
    public String authenticate(){
        return "token";
    }
}
