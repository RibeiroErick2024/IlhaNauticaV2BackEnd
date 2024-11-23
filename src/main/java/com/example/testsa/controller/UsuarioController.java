package com.example.testsa.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testsa.converter.UsuarioConverter;
import com.example.testsa.dto.res.Usuario.UsuarioGeralDTORes;
import com.example.testsa.dto.res.Usuario.UsuarioLocadorDTORes;
import com.example.testsa.entities.Usuario;
import com.example.testsa.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    AgendamentoController agendamentoController;

    // Busca todos os usuarios
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
    @GetMapping("locador/{id}")
    public ResponseEntity<UsuarioLocadorDTORes> buscarUsuario(@PathVariable(name = "id") UUID id) {
        Usuario u = usuarioService.buscarUsuarioPorId(id);

        if (u == null) {
            return ResponseEntity.notFound().build();
        }

        UsuarioLocadorDTORes usuarioDTO = UsuarioConverter.usuarioConverterLocador(u);
        return ResponseEntity.ok(usuarioDTO);
    }

    @PostMapping("/completarcadastro/{id}")
    public ResponseEntity<UsuarioGeralDTORes> cadastrarUsuario(@RequestBody Usuario completarUsuario, @PathVariable  UUID id) {
        Usuario u = usuarioService.completarUsuario(id, completarUsuario);
        UsuarioGeralDTORes usuarioDTO = UsuarioConverter.usuarioConverterGeral(u);
        return ResponseEntity.ok(usuarioDTO);
    }
    
    @PutMapping("editar/{id}")
    public ResponseEntity<UsuarioGeralDTORes> completarCadastro(@PathVariable UUID id, @RequestBody Usuario editarUsuario) {
        Usuario u = usuarioService.editarUsuario(id, editarUsuario);
        UsuarioGeralDTORes usuarioDTO = UsuarioConverter.usuarioConverterGeral(u);
        return ResponseEntity.ok(usuarioDTO);
    
    }
    
        // @PostMapping("/cadastroLocador") // Arrumar
        // public ResponseEntity<?> cadastrarLocador(@RequestBody CadastroUsuarioDTO criarUsuario) {
        //     Usuario entity = UsuarioConverter.cadastroDTOConverterUsuario(criarUsuario);
        //     var response = usuarioService.criarUsuario(entity);
        //     return ResponseEntity.ok(response);
        // }
    
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
