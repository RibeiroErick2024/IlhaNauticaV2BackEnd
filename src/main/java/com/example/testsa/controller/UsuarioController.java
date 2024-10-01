package com.example.testsa.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testsa.entities.Usuario;
import com.example.testsa.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/")
    public ResponseEntity<?> getallUsers() {

        var teams = usuarioService.getAllUsuario();
        return ResponseEntity.ok(teams);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable (name = "id") UUID id) {
        Usuario u = usuarioService.getUsuarioById(id);

        return ResponseEntity.ok(u);
    }

    @PostMapping("/post")
    public ResponseEntity<Usuario> postMethodName(@RequestBody Usuario entity) {
        var response = usuarioService.createUsuario(entity);
        
        return ResponseEntity.ok(response);
    }
    
    @PutMapping("path/{id}")
    public ResponseEntity<Usuario> putMethodName(@PathVariable String id, @RequestBody Usuario entity) {
       
        var response = usuarioService.createUsuario(entity);
        
        return ResponseEntity.ok(response);
        
    }

}