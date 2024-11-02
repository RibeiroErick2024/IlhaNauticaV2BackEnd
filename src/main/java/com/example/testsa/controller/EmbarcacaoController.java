package com.example.testsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testsa.service.EmbarcacaoService;

@RestController
@RequestMapping("/embarcacao")
public class EmbarcacaoController {
    
    
    @Autowired
    EmbarcacaoService embarcacaoService;

    @GetMapping("/")
    public ResponseEntity<?> getallEmbarcacao(){
            var embarcacoes = embarcacaoService.getAllEmbarcacaos();

            List<EmbarcacaoDTORes> dtoRes = embarcacoes
    }
}
