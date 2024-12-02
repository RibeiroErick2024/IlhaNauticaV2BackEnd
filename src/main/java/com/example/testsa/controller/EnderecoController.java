package com.example.testsa.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testsa.converter.EnderecoConverter;
import com.example.testsa.dto.res.EnderecoDTORes;
import com.example.testsa.entities.Endereco;
import com.example.testsa.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @GetMapping("/")
    public ResponseEntity<List<?>> buscarEndereco() {
        List<Endereco> enderecos = enderecoService.buscarTodos();

        if (enderecos == null) {
            return ResponseEntity.notFound().build();
        }

        List<EnderecoDTORes> dto = enderecos
                .stream()
                .map(e -> EnderecoConverter.entidadeParaDto(e)).toList();

        return ResponseEntity.ok(dto);
    }
    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<EnderecoDTORes>> buscarEnderecoPorIdUsuario(@PathVariable(name = "id") UUID id) {
        List<Endereco> enderecos = enderecoService.buscarPorIdUsuario(id);

        if (enderecos == null) {
            return ResponseEntity.notFound().build();
        }

        List<EnderecoDTORes> dto = enderecos
                .stream()
                .map(e -> EnderecoConverter.entidadeParaDto(e)).toList();

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/embarcacao")
    public ResponseEntity<?> cadastrarEnderecoEmbarcacao(@RequestBody Endereco entity) {
        Endereco endereco = enderecoService.adicionarEnderecoEmbarcacao(entity);
        EnderecoDTORes dto = EnderecoConverter.entidadeParaDto(endereco);

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/usuario")
    public ResponseEntity<?> cadastrarEnderecoUsuario(@RequestBody Endereco entity) {
        Endereco endereco = enderecoService.adicionarEnderecoUsuario(entity);
        EnderecoDTORes dto = EnderecoConverter.entidadeParaDto(endereco);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarEndereco(@PathVariable UUID id, @RequestBody Endereco entity) {
        Endereco endereco = enderecoService.atualizarEndereco(id, entity);
        EnderecoDTORes dto = EnderecoConverter.entidadeParaDto(endereco);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarendereco(@PathVariable UUID id) {
        enderecoService.deletarendereco(id);
        return ResponseEntity.ok("Endereco deletado.");
    }

}
