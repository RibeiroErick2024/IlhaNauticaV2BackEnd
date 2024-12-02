package com.example.testsa.controller;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testsa.converter.AgendamentoConverter;
import com.example.testsa.dto.res.AgendamentosDTORes;
import com.example.testsa.entities.Agendamento;
import com.example.testsa.service.AgendamentoService;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    public AgendamentoController(AgendamentoService agendamentoService) {
        this.agendamentoService = agendamentoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<Agendamento> criarAgendamento(@RequestBody Agendamento agendamento) {
        Agendamento createdAgendamento = agendamentoService.createAgendamento(agendamento);
        return ResponseEntity.status(201).body(createdAgendamento);
    }


    @GetMapping
    public ResponseEntity<List<AgendamentosDTORes>> buscarTodosAgendamentos() {
        List<AgendamentosDTORes> agendamentosDTO = agendamentoService.buscarTodosAgendamentos();
        return ResponseEntity.ok(agendamentosDTO);
    }

    @GetMapping("/{id}")  
    public ResponseEntity<AgendamentosDTORes> buscarAgendamentoPorId(@PathVariable(name = "id") UUID id) {
        Optional<Agendamento> agendamentoOpt = agendamentoService.buscarAgendamentoPorId(id);
    
        if (agendamentoOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
    
        Agendamento agendamento = agendamentoOpt.get();
        AgendamentosDTORes agendamentoDTO = AgendamentoConverter.agendamentoConverterDTO(agendamento); 
    
        return ResponseEntity.ok(agendamentoDTO);
    }
  
    @PutMapping("/{id}")
    public ResponseEntity<Agendamento> updateAgendamento(@PathVariable UUID id, @RequestBody Agendamento agendamento) {
        Agendamento updatedAgendamento = agendamentoService.updateAgendamento(id, agendamento);
        return ResponseEntity.ok(updatedAgendamento); 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgendamento(@PathVariable UUID id) {
        agendamentoService.deleteAgendamento(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }
}
