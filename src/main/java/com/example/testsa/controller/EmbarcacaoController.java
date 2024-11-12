package com.example.testsa.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.testsa.converter.EmbarcacaoConverter;
import com.example.testsa.dto.res.Embarcacao.EmbarcacaoDTORes;
import com.example.testsa.entities.Embarcacao;
import com.example.testsa.service.EmbarcacaoService;

@RestController
@RequestMapping("/embarcacao")
public class EmbarcacaoController {

    @Autowired
    private EmbarcacaoService embarcacaoService;

    // Endpoint para listar todas as embarcações
    @GetMapping
    public ResponseEntity<List<EmbarcacaoDTORes>> getAllEmbarcacoes() {
        List<Embarcacao> embarcacoes = embarcacaoService.getAllEmbarcacaos();

        List<EmbarcacaoDTORes> dto = embarcacoes
        .stream()
        .map(e -> EmbarcacaoConverter.embarcacaoConverterDTO(e))
        .toList();
        return ResponseEntity.ok(dto);
    }

    // Endpoint para buscar uma embarcação por ID
    @GetMapping("/{id}")
    public ResponseEntity<EmbarcacaoDTORes> getEmbarcacaoById(@PathVariable UUID id) {
        Embarcacao embarcacao = embarcacaoService.getEmbarcacaoById(id);
        EmbarcacaoDTORes dto = EmbarcacaoConverter.embarcacaoConverterDTO(embarcacao);
        if (embarcacao != null) {
            return ResponseEntity.ok(dto);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para criar uma nova embarcação
    @PostMapping
    public ResponseEntity<EmbarcacaoDTORes> createEmbarcacao(@RequestBody Embarcacao embarcacao) {
        Embarcacao createdEmbarcacao = embarcacaoService.creatEmbarcacao(embarcacao);
        EmbarcacaoDTORes dto = EmbarcacaoConverter.embarcacaoConverterDTO(createdEmbarcacao);

        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    // Endpoint para atualizar uma embarcação existente
    @PutMapping("/{id}")
    public ResponseEntity<EmbarcacaoDTORes> updateEmbarcacao(
            @PathVariable UUID id,
            @RequestBody Embarcacao embarcacao) {
        try {
            Embarcacao updatedEmbarcacao = embarcacaoService.updateEmbarcacao(id, embarcacao);
            EmbarcacaoDTORes dto = EmbarcacaoConverter.embarcacaoConverterDTO(updatedEmbarcacao);


            return new ResponseEntity<>(dto, HttpStatus.OK);
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
