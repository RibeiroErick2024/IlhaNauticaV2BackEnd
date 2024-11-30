package com.example.testsa.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testsa.dto.res.AvaliacaoDTORes;
import com.example.testsa.entities.Avaliacao;
import com.example.testsa.service.AvaliacaoService;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;

    @GetMapping("/")
    public ResponseEntity<List<AvaliacaoDTORes>> buscarTodos() {

        List<AvaliacaoDTORes> dto = avaliacaoService.buscarTodos();

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/criar")
    public ResponseEntity<AvaliacaoDTORes> salvarAvaliacao(@RequestBody Avaliacao avaliacao) {
        AvaliacaoDTORes resultado = avaliacaoService.salvarAvaliacao(avaliacao);
        return ResponseEntity.status(201).body(resultado);
    }

    @GetMapping("embarcacao/{idEmbarcacao}")
    public ResponseEntity<List<AvaliacaoDTORes>> buscarPorIdUsuario(@PathVariable UUID idEmbarcacao) {
        List<AvaliacaoDTORes> ap = avaliacaoService.buscarPorEmbarcacao(idEmbarcacao);

        if (ap.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(ap);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvaliacao(@PathVariable Long id) {
        avaliacaoService.deleteAvaliacao(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }

}