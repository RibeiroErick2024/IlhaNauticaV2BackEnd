package com.example.testsa.service;

import java.util.List;
import java.util.stream.Collectors;

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

        
       usuarioRepository.findByEmail(input.getEmail())
       .ifPresent(user -> {
           throw new BadCredentialsException("Email já cadastrado.");
       });
        Usuario user = UsuarioConverter.cadastroDTOConverterUsuario(input, passwordEncoder.encode(input.getSenha()));

      

        return usuarioRepository.save(user);
    }

 public List<Usuario> signupTemp(List<Usuario> input) {
    // Mapeia a lista de usuários, criptografando a senha de cada um
    List<Usuario> all = input.stream()
            .map(u -> {
                u.setSenha(passwordEncoder.encode(u.getSenha())); // Criptografa a senha
                return u; // Retorna o usuário atualizado
            })
            .collect(Collectors.toList()); // Coleta em uma lista novamente

    // Salva todos os usuários modificados
    return usuarioRepository.saveAll(all); // Aqui você usa a lista 'all', que tem as senhas criptografadas
}

    public Usuario authenticate(LoginDTO input) {
        System.out.println("tbm");
        Usuario usuario = usuarioRepository.findByEmail(input.getEmail())
                .orElseThrow(() -> new BadCredentialsException("Email não encontrado"));

        if (!passwordEncoder.matches(input.getSenha(), usuario.getSenha())) {
            throw new BadCredentialsException("Senha incorreta");
        }

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(input.getEmail(), input.getSenha()));
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("Credenciais inválidas fornecidas.");
        }

        return usuario;
    }

}
