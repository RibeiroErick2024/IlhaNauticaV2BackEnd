package com.example.testsa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testsa.converter.MarinheiroConverter;
import com.example.testsa.dto.res.MarinheiroDTORes;
import com.example.testsa.entities.Marinheiro;
import com.example.testsa.service.MarinheiroService;

@RestController
@RequestMapping("/marinheiro")
public class MarinheiroController {

    @Autowired
    MarinheiroService marinheiroService;

    @GetMapping("/")
    public ResponseEntity <List<Marinheiro>> buscarTodos() {

        var response = marinheiroService.buscarTodos();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<MarinheiroDTORes> cadastrar(@RequestBody Marinheiro entity) {
        Marinheiro marinheiro = marinheiroService.cadastrar(entity);
        MarinheiroDTORes marinheiroDto = MarinheiroConverter.marinheiroDTORes(marinheiro);
        return ResponseEntity.ok(marinheiroDto);
    }

}
