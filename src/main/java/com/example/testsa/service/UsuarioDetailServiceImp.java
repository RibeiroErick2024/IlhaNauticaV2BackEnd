package com.example.testsa.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.testsa.UsuarioAuthenticated;
import com.example.testsa.repositories.UsuarioRepository;

public class UsuarioDetailServiceImp implements UserDetailsService{
    private final UsuarioRepository usuarioRepository;

    public UsuarioDetailServiceImp(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(username)
        .map(UsuarioAuthenticated::new)
        .orElseThrow(() -> new UsernameNotFoundException("Usuario/email não encontrado"));
    }
    
}
