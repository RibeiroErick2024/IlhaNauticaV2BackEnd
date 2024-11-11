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
import com.example.testsa.dto.res.Marinheiro.MarinheiroComUsuarioDTO;
import com.example.testsa.entities.Marinheiro;
import com.example.testsa.service.MarinheiroService;

@RestController
@RequestMapping("/marinheiro")
public class MarinheiroController {

    @Autowired
    MarinheiroService marinheiroService;

    @GetMapping("/")
    public ResponseEntity<List<MarinheiroComUsuarioDTO>> buscarTodos() {

        List<Marinheiro> marinheiro = marinheiroService.buscarTodos();

        List<MarinheiroComUsuarioDTO> dto = marinheiro
                .stream().map(m -> MarinheiroConverter.entidadeParaMarinheiroComUsuarioDTO(m)).toList();

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarinheiroComUsuarioDTO> buscarMarinheiroPorId(@PathVariable(name = "id") UUID id) {
        Marinheiro m = marinheiroService.buscarPorId(id);

        if (m == null) {
            return ResponseEntity.notFound().build();
        }

        MarinheiroComUsuarioDTO dto = MarinheiroConverter.entidadeParaMarinheiroComUsuarioDTO(m);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<MarinheiroComUsuarioDTO> cadastrarMarinheiro(@RequestBody Marinheiro entity) {
        Marinheiro marinheiro = marinheiroService.cadastrar(entity);
        MarinheiroComUsuarioDTO dto = MarinheiroConverter.entidadeParaMarinheiroComUsuarioDTO(marinheiro);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<MarinheiroComUsuarioDTO> editarMarinheiro(@PathVariable UUID id,
            @RequestBody Marinheiro entity) {
        Marinheiro marinheiro = marinheiroService.atualizarMarinheiro(id, entity);
        MarinheiroComUsuarioDTO dto = MarinheiroConverter.entidadeParaMarinheiroComUsuarioDTO(marinheiro);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/deletar/{id}")
    public ResponseEntity<?> deletarMarinheiro(@PathVariable UUID id) {
        marinheiroService.deletarMarinheiro(id);
        return ResponseEntity.ok("Marinheiro deletado.");
    }

}
