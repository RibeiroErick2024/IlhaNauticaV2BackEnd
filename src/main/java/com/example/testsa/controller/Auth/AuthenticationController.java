package com.example.testsa.controller.Auth;

import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDTO loginUserDTO) {
        Usuario  authenticatedUser = authenticationService.authenticate(loginUserDTO);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse response = new LoginResponse();
        response.setToken(jwtToken);
        response.setExpiresIn(jwtService.getExpirationTime());
        response.setIdUsuario(authenticatedUser.getId());

        return ResponseEntity.ok(response);
        
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody CadastroUsuarioDTO criarUsuario) {
        var response = authenticationService.signup(criarUsuario);
        // Usuario entity = UsuarioConverter.cadastroDTOConverterUsuario(criarUsuario);
        return ResponseEntity.ok(response);
    }
}
