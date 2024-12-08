package com.example.testsa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testsa.dto.req.LoginDTO;
import com.example.testsa.dto.req.Usuario.CadastroUsuarioDTO;
import com.example.testsa.dto.res.LoginResponse;
import com.example.testsa.entities.Usuario;
import com.example.testsa.service.AuthenticationService;
import com.example.testsa.service.JwtService;
import com.example.testsa.service.UsuarioService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    @Autowired
    UsuarioService usuarioService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

   @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginUserDTO) {
            Usuario authenticatedUser = authenticationService.authenticate(loginUserDTO);

            String jwtToken = jwtService.generateToken(authenticatedUser);

            LoginResponse response = new LoginResponse();
            response.setToken(jwtToken);
            response.setExpiresIn(jwtService.getExpirationTime());
            response.setIdUsuario(authenticatedUser.getId());

            return ResponseEntity.ok(response);
      
    }

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastrarUsuario(@RequestBody CadastroUsuarioDTO criarUsuario) {
        try {
            authenticationService.signup(criarUsuario);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuário cadastrado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao cadastrar usuário: " + e.getMessage());
        } 
    }
    
 
}
