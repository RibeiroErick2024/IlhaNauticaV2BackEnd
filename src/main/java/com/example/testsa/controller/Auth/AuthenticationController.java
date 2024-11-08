package com.example.testsa.controller.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testsa.converter.UsuarioConverter;
import com.example.testsa.dto.req.CadastroUsuarioDTO;
import com.example.testsa.entities.Usuario;
import com.example.testsa.service.AuthenticationService;
import com.example.testsa.service.UsuarioService;


@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @Autowired
    UsuarioService usuarioService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("authenticate")
    public String authenticate() {
        return authenticationService.authenticate();
    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody Usuario usuario) {
        Usuario usuarioLogado = usuarioService.loginUsuario(usuario.getEmail(), usuario.getSenha());
        return ResponseEntity.ok(usuarioLogado);
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody CadastroUsuarioDTO criarUsuario) {
        Usuario entity = UsuarioConverter.dtoConverterUsuario(criarUsuario);
        var response = usuarioService.createUsuario(entity);
        return ResponseEntity.ok(response);
    }
}
