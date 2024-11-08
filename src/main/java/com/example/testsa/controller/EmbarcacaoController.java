package com.example.testsa.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.testsa.entities.Embarcacao;
import com.example.testsa.service.EmbarcacaoService;

@RestController
@RequestMapping("/embarcacoes")
public class EmbarcacaoController {

    @Autowired
    private EmbarcacaoService embarcacaoService;

    // Endpoint para listar todas as embarcações
    @GetMapping
    public ResponseEntity<List<Embarcacao>> getAllEmbarcacoes() {
        List<Embarcacao> embarcacoes = embarcacaoService.getAllEmbarcacaos();
        return new ResponseEntity<>(embarcacoes, HttpStatus.OK);
    }

    // Endpoint para buscar uma embarcação por ID
    @GetMapping("/{id}")
    public ResponseEntity<Embarcacao> getEmbarcacaoById(@PathVariable UUID id) {
        Embarcacao embarcacao = embarcacaoService.getEmbarcacaoById(id);
        if (embarcacao != null) {
            return new ResponseEntity<>(embarcacao, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para criar uma nova embarcação
    @PostMapping
    public ResponseEntity<Embarcacao> createEmbarcacao(@RequestBody Embarcacao embarcacao) {
        Embarcacao createdEmbarcacao = embarcacaoService.creatEmbarcacao(embarcacao);
        return new ResponseEntity<>(createdEmbarcacao, HttpStatus.CREATED);
    }

    // Endpoint para atualizar uma embarcação existente
    @PutMapping("/{id}")
    public ResponseEntity<Embarcacao> updateEmbarcacao(
            @PathVariable UUID id, 
            @RequestBody Embarcacao embarcacao) {
        try {
            Embarcacao updatedEmbarcacao = embarcacaoService.updateEmbarcacao(id, embarcacao);
            return new ResponseEntity<>(updatedEmbarcacao, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para deletar uma embarcação
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmbarcacao(@PathVariable UUID id) {
        try {
            embarcacaoService.deleteEmbarcacao(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
