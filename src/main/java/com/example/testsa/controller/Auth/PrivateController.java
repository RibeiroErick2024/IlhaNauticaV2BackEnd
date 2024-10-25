package com.example.testsa.controller.Auth;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("private")
public class PrivateController {
    
    @GetMapping()
    public String getMethodName() {
        return "Hello private route";
    }
    
}
