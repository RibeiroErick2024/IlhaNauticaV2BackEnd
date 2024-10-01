package com.example.testsa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testsa.entities.Marinheiro;
import com.example.testsa.service.MarinheiroService;

@RestController
@RequestMapping("/piloto")
public class MarinheiroController {

    @Autowired
    MarinheiroService marinheiroService;

    @GetMapping("/")
    public ResponseEntity <List<Marinheiro>> getMethodName() {

        var response = marinheiroService.getAllMarinheiro();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/post")
    public ResponseEntity<Marinheiro> postMethodName(@RequestBody Marinheiro entity) {

        return ResponseEntity.ok(entity);
    }

}
