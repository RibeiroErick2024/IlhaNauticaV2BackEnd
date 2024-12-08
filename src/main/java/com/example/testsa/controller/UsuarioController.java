package com.example.testsa.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testsa.converter.UsuarioConverter;
import com.example.testsa.dto.req.Usuario.UsuarioDTOReq;
import com.example.testsa.dto.res.Usuario.UsuarioGeralDTORes;
import com.example.testsa.dto.res.Usuario.UsuarioLocadorDTORes;
import com.example.testsa.dto.res.Usuario.UsuarioSimplesDTO;
import com.example.testsa.entities.Usuario;
import com.example.testsa.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    AgendamentoController agendamentoController;


    @GetMapping("/")
    public ResponseEntity<?> buscarTodosUsers() {
        var usuarios = usuarioService.buscarTodosUsuario();

        List<UsuarioGeralDTORes> dtoRes = usuarios
                .stream().map(u -> UsuarioConverter.usuarioConverterGeral(u)).toList();

        if (usuarios.isEmpty()) {
            return ResponseEntity.ok("Nenhum usuário encontrado");
        }
        return ResponseEntity.ok(dtoRes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioGeralDTORes> buscarUsuarioGeral(@PathVariable(name = "id") UUID id) {
        Usuario u = usuarioService.buscarUsuarioPorId(id);

        if (u == null) {
            return ResponseEntity.notFound().build();
        }

        UsuarioGeralDTORes usuarioDTO = UsuarioConverter.usuarioConverterGeral(u);
        return ResponseEntity.ok(usuarioDTO);
    }
    @GetMapping("/embarcacao/{id}")
    public ResponseEntity<UsuarioSimplesDTO> buscarUsuarioEmbarcacao(@PathVariable(name = "id") UUID id) {
        Usuario u = usuarioService.buscarUsuarioPorId(id);

        if (u == null) {
            return ResponseEntity.notFound().build();
        }

        UsuarioSimplesDTO usuarioDTO = UsuarioConverter.usuarioConverterSimples(u);
        return ResponseEntity.ok(usuarioDTO);
    }
    @GetMapping("/locador/{id}")
    public ResponseEntity<UsuarioLocadorDTORes> buscarUsuario(@PathVariable(name = "id") UUID id) {
        Usuario u = usuarioService.buscarUsuarioPorId(id);

        if (u == null) {
            return ResponseEntity.notFound().build();
        }

        UsuarioLocadorDTORes usuarioDTO = UsuarioConverter.usuarioConverterLocador(u);
        return ResponseEntity.ok(usuarioDTO);
    }

    @PatchMapping("/completarcadastro/{id}")
    public ResponseEntity<UsuarioGeralDTORes> cadastrarUsuario(@RequestBody UsuarioDTOReq completarUsuario, @PathVariable  UUID id) {
        UsuarioGeralDTORes usuarioDTO = usuarioService.completarUsuario(id, completarUsuario);
        
        return ResponseEntity.ok(usuarioDTO);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioGeralDTORes> completarCadastro(@PathVariable UUID id, @RequestBody UsuarioDTOReq editarUsuario) {
        UsuarioGeralDTORes usuarioDTO = usuarioService.editarUsuario(id, editarUsuario);
        return ResponseEntity.ok(usuarioDTO);
    
    }
    
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable UUID id) {
        System.out.println(id);
        try {
            usuarioService.deletarUsuario(id);
            return ResponseEntity.ok("Usuário deletado");
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

}
