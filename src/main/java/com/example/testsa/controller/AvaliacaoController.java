package com.example.testsa.controller;

import com.example.testsa.converter.MarinheiroConverter;
import com.example.testsa.dto.req.AvaliacaoDTOReq;
import com.example.testsa.dto.res.AvaliacaoDTORes;
import com.example.testsa.dto.res.Marinheiro.MarinheiroComUsuarioDTO;
import com.example.testsa.entities.Marinheiro;
import com.example.testsa.service.AvaliacaoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<AvaliacaoDTORes> salvarAvaliacao(@RequestBody AvaliacaoDTOReq avaliacaoDTO) {
        AvaliacaoDTORes resultado = avaliacaoService.salvarAvaliacao(avaliacaoDTO);
        return new ResponseEntity<>(resultado, HttpStatus.CREATED);
    }
}