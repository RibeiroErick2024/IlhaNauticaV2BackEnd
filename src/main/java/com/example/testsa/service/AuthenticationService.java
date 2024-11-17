package com.example.testsa.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.testsa.converter.UsuarioConverter;
import com.example.testsa.dto.req.LoginDTO;
import com.example.testsa.dto.req.Usuario.CadastroUsuarioDTO;
import com.example.testsa.entities.Usuario;
import com.example.testsa.repositories.UsuarioRepository;

@Service
public class AuthenticationService {
    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UsuarioRepository usuarioRepository,AuthenticationManager authenticationManager,PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuario signup(CadastroUsuarioDTO input) {
        Usuario user = UsuarioConverter.cadastroDTOConverterUsuario(input, passwordEncoder.encode(input.getSenha()));

        // user.setNomeCompleto(input.getNomeCompleto());
        // user.setEmail(input.getEmail());
        // user.setSenha(passwordEncoder.encode(input.getSenha()));
        // user.setRole(input.getRole());

        return usuarioRepository.save(user);
    }

    public Usuario authenticate(LoginDTO input) {
       try {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getSenha()));

        return usuarioRepository.findByEmail(input.getEmail())
                .orElseThrow();
    
       } catch (Exception e) {
            throw new BadCredentialsException("Credenciais inválidas fornecidas");
       } 
}
}
