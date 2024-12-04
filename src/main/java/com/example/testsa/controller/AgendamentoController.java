package com.example.testsa.controller;

import com.example.testsa.converter.AgendamentoConverter;
import com.example.testsa.dto.res.AgendamentosDTORes;
import com.example.testsa.entities.Agendamento;
import com.example.testsa.service.AgendamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<AgendamentosDTORes> criarAgendamento(@RequestBody Agendamento agendamento) {
        Agendamento createdAgendamento = agendamentoService.createAgendamento(agendamento);
        AgendamentosDTORes agendamentoDTO = AgendamentoConverter.agendamentoConverterDTO(createdAgendamento);
        return ResponseEntity.status(201).body(agendamentoDTO);
    }

    @GetMapping
    public ResponseEntity<List<AgendamentosDTORes>> buscarTodosAgendamentos() {
        List<AgendamentosDTORes> agendamentosDTO = agendamentoService.buscarTodosAgendamentos();
        return ResponseEntity.ok(agendamentosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentosDTORes> buscarAgendamentoPorId(@PathVariable UUID id) {
        Optional<Agendamento> agendamentoOpt = agendamentoService.buscarAgendamentoPorId(id);
        if (agendamentoOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Agendamento agendamento = agendamentoOpt.get();
        AgendamentosDTORes agendamentoDTO = AgendamentoConverter.agendamentoConverterDTO(agendamento);
        return ResponseEntity.ok(agendamentoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendamentosDTORes> updateAgendamento(@PathVariable UUID id, @RequestBody Agendamento agendamento) {
        Agendamento updatedAgendamento = agendamentoService.updateAgendamento(id, agendamento);
        AgendamentosDTORes agendamentoDTO = AgendamentoConverter.agendamentoConverterDTO(updatedAgendamento);
        return ResponseEntity.ok(agendamentoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgendamento(@PathVariable UUID id) {
        agendamentoService.deleteAgendamento(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }
}
