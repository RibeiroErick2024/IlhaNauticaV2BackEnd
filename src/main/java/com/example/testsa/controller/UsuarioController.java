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
import com.example.testsa.dto.req.Usuario.CadastroUsuarioDTO;
import com.example.testsa.dto.res.Usuario.UsuarioLocadorDTORes;
import com.example.testsa.entities.Usuario;
import com.example.testsa.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    // Busca todos os usuarios
    @GetMapping("/")
    public ResponseEntity<?> buscarTodosUsers() {
        var usuarios = usuarioService.buscarTodosUsuario();

        List<UsuarioLocadorDTORes> dtoRes = usuarios
                .stream().map(u -> UsuarioConverter.usuarioConverterLocador(u)).toList();

        if (usuarios.isEmpty()) {
            return ResponseEntity.ok("Nenhum usuário encontrado");
        }
        return ResponseEntity.ok(dtoRes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioLocadorDTORes> buscarUsuario(@PathVariable(name = "id") UUID id) {
        Usuario u = usuarioService.buscarUsuarioPorId(id);

        if (u == null) {
            return ResponseEntity.notFound().build();
        }

        UsuarioLocadorDTORes usuarioDTO = UsuarioConverter.usuarioConverterLocador(u);
        return ResponseEntity.ok(usuarioDTO);
    }

    // @PostMapping("/criar")
    // public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario entity) {
    //     var response = usuarioService.criarUsuario(entity);
    //     return ResponseEntity.ok(response);
    // }

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody CadastroUsuarioDTO criarUsuario) {
        Usuario entity = UsuarioConverter.cadastroDTOConverterUsuario(criarUsuario);
        var response = usuarioService.criarUsuario(entity);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/cadastroLocador") // Arrumar
    public ResponseEntity<?> cadastrarLocador(@RequestBody CadastroUsuarioDTO criarUsuario) {
        Usuario entity = UsuarioConverter.cadastroDTOConverterUsuario(criarUsuario);
        var response = usuarioService.criarUsuario(entity);
        return ResponseEntity.ok(response);
    }

    @PutMapping("editar/{id}")
    public ResponseEntity<Usuario> completarCadastro(@PathVariable UUID id, @RequestBody Usuario entity) {
        var response = usuarioService.editarUsuario(id, entity);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarUsuario(@PathVariable UUID id) {
        try {
            usuarioService.deletarUsuario(id);
            return ResponseEntity.ok("Usuário deletado");

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Usuario não encontrado");
        }

    }

    // Endpoint de login
    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody Usuario usuario) {
        Usuario usuarioLogado = usuarioService.loginUsuario(usuario.getEmail(), usuario.getSenha());
        return ResponseEntity.ok(usuarioLogado);
    }
}
