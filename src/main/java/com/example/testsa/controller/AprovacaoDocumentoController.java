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

import com.example.testsa.converter.AprovacaoDocumentoConverter;
import com.example.testsa.dto.res.AprovacaoDocumentoDTO;
import com.example.testsa.entities.AprovacaoDocumento;
import com.example.testsa.service.AprovacaoDocumentoService;

@RestController
@RequestMapping("/aprovacaodocumento")
public class AprovacaoDocumentoController {

    @Autowired
    AprovacaoDocumentoService aprovacaoDocumentoService;
    @GetMapping("/todas")
    public ResponseEntity<List<AprovacaoDocumentoDTO>> buscarTodas() {
        List<AprovacaoDocumento> ap = aprovacaoDocumentoService.buscarTodas();

        List<AprovacaoDocumentoDTO> listap = ap.stream()
                .map(e -> AprovacaoDocumentoConverter.entidadeParaDTO(e))
                .toList();
        if (ap.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(listap);
    }
    @GetMapping("/pendentes")
    public ResponseEntity<List<AprovacaoDocumentoDTO>> buscarTodasPendentes() {
        List<AprovacaoDocumento> ap = aprovacaoDocumentoService.buscarPorStatusPendente();

        List<AprovacaoDocumentoDTO> listap = ap.stream()
                .map(e -> AprovacaoDocumentoConverter.entidadeParaDTO(e))
                .toList();
        if (ap.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(listap);
    }

    @GetMapping("usuario/{idUsuario}")
    public ResponseEntity<List<AprovacaoDocumentoDTO>> buscarPorIdUsuario(@PathVariable UUID idUsuario) {
        List<AprovacaoDocumento> ap = aprovacaoDocumentoService.buscarPorUsuario(idUsuario);

        List<AprovacaoDocumentoDTO> listap = ap.stream()
                .map(e -> AprovacaoDocumentoConverter.entidadeParaDTO(e))
                .toList();
        if (ap.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(listap);
    }

    @PostMapping("/{idAprovacao}")
    public ResponseEntity<AprovacaoDocumentoDTO> mudarStatus(@RequestBody AprovacaoDocumento entity,
            @PathVariable Long idAprovacao) {

        AprovacaoDocumento ent = aprovacaoDocumentoService.mudarStatus(entity, idAprovacao);
        AprovacaoDocumentoDTO res = AprovacaoDocumentoConverter.entidadeParaDTO(ent);
        return ResponseEntity.ok(res);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {

        aprovacaoDocumentoService.deletar(id);
        return ResponseEntity.ok("Deletado");

    }

}
