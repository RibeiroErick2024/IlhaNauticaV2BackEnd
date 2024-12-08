package com.example.testsa.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.testsa.converter.EmbarcacaoConverter;
import com.example.testsa.dto.req.EmbarcacaoDTOReq;
import com.example.testsa.dto.res.Embarcacao.EmbarcacaoCardDTO;
import com.example.testsa.dto.res.Embarcacao.EmbarcacaoDTORes;
import com.example.testsa.entities.Embarcacao;
import com.example.testsa.service.EmbarcacaoService;

@RestController
@RequestMapping("/embarcacao")
public class EmbarcacaoController {

    @Autowired
    private EmbarcacaoService embarcacaoService;

    @GetMapping("/")
    public ResponseEntity<List<EmbarcacaoCardDTO>> buscarTodasEmbarcacoes() {
        System.out.println("Embarcacao controller");
        List<Embarcacao> embarcacoes = embarcacaoService.buscarTodasEmbarcacoes();

        List<EmbarcacaoCardDTO> dto = embarcacoes
        .stream()
        .map(e -> EmbarcacaoConverter.embarcacaoConverterCardDTO(e))
        .toList();
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmbarcacaoDTORes> buscarEmbarcacaoById(@PathVariable UUID id) {
        Embarcacao embarcacao = embarcacaoService.buscarEmbarcacaoPorId(id);
        EmbarcacaoDTORes dto = EmbarcacaoConverter.embarcacaoConverterDTO(embarcacao);
        if (embarcacao != null) {
            return ResponseEntity.ok(dto);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<EmbarcacaoDTORes> createEmbarcacao(@RequestBody EmbarcacaoDTOReq embarcacao) {
        EmbarcacaoDTORes embarcacaoCriada = embarcacaoService.criarEmbarcacao(embarcacao);
      
        return new ResponseEntity<>(embarcacaoCriada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmbarcacaoDTORes> updateEmbarcacao(
            @PathVariable UUID id,
            @RequestBody EmbarcacaoDTOReq embarcacao) {
        try {
            EmbarcacaoDTORes embarcacaoAtualizada = embarcacaoService.atualizarEmbarcacao(id, embarcacao);


            return new ResponseEntity<>(embarcacaoAtualizada, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

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
