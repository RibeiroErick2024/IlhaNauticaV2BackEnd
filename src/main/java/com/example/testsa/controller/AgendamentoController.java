package com.example.testsa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testsa.entities.Agendamento;
import com.example.testsa.service.AgendamentoService;



@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

   
    // @GetMapping("/")
    // public ResponseEntity<List<Agendamento>> getAllAgendamentos() {
    //     List<Agendamento> response = agendamentoService.getAllAgendamento();
    //     return ResponseEntity.ok(response);
    // }

  
    @GetMapping("/{id}")
    public ResponseEntity<?> getAgendamentoById(@PathVariable Long id) {
        Optional<Agendamento> agendamento = agendamentoService.getAgendamentoById(id);
        return ResponseEntity.ok(agendamento);
    }

   
    // @PostMapping("/post")
    // public ResponseEntity<Agendamento> createAgendamento(@RequestBody Agendamento entity) {
    //     Agendamento createdAgendamento = agendamentoService.saveAgendamento(entity);
    //     return ResponseEntity.status(HttpStatus.CREATED).body(createdAgendamento);
    // }

    
    // @PutMapping("/{id}")
    // public ResponseEntity<Agendamento> updateAgendamento(@PathVariable Long id, @RequestBody Agendamento entity) {
    //     Agendamento updatedAgendamento = agendamentoService.updateAgendamento(id, entity);
    //     return ResponseEntity.ok(updatedAgendamento);
    // }

    
    // @PatchMapping("/{id}")
    // public ResponseEntity<Agendamento> partialUpdateAgendamento(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
    //     Agendamento updatedAgendamento = agendamentoService.partialUpdateAgendamento(id, updates);
    //     return ResponseEntity.ok(updatedAgendamento);
    // }

   
    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteAgendamento(@PathVariable Long id) {
    //     agendamentoService.deleteAgendamento(id);
    //     return ResponseEntity.noContent().build(); // Retorna 204 No Content
    // }
}
