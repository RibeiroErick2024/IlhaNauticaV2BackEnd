package com.example.testsa.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<List<MarinheiroDTORes>> buscarTodos() {

        List<Marinheiro> marinheiro = marinheiroService.buscarTodos();
       
        List<MarinheiroDTORes> dto = marinheiro
                .stream().map(m -> MarinheiroConverter.marinheiroDTOResponse(m)).toList();

        return ResponseEntity.ok(dto);
    }

     @GetMapping("/{id}")
    public ResponseEntity<MarinheiroDTORes> buscarMarinheiroPorId(@PathVariable(name = "id") UUID id) {
        Marinheiro m = marinheiroService.buscarPorId(id);
    
        if (m == null) {
            return ResponseEntity.notFound().build();
        }
    
        MarinheiroDTORes dto = MarinheiroConverter.marinheiroDTOResponse(m);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<MarinheiroDTORes> cadastrarMarinheiro(@RequestBody Marinheiro entity) {
        Marinheiro marinheiro = marinheiroService.cadastrar(entity);
        MarinheiroDTORes dto = MarinheiroConverter.marinheiroDTOResponse(marinheiro);
        return ResponseEntity.ok(dto);
    }

}
