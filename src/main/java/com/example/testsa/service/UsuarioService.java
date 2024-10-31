package com.example.testsa.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testsa.entities.Usuario;
import com.example.testsa.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuario() {
        return usuarioRepository.findAll();
    }

    
    @Transactional
    public Usuario createUsuario(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }

    

    public Usuario getUsuarioById (UUID id){
        
        Optional<Usuario> optUsuario = usuarioRepository.findById(id);
        if (optUsuario.isPresent()) {
            Usuario usuarioEncontrado = optUsuario.get();
            return usuarioEncontrado;
        }

        return null;
    }
    
    @Transactional
    public Usuario updateUsuario(UUID id, Usuario usuario) {
        Optional<Usuario> optionalUserToUpdateData = usuarioRepository.findById(id);
        
        if(optionalUserToUpdateData.isPresent()){
            Usuario userToUpdateData = optionalUserToUpdateData.get();
            userToUpdateData.setCpf(usuario.getCpf());
            userToUpdateData.setNomeCompleto(usuario.getNomeCompleto());
            userToUpdateData.setEmail(usuario.getEmail());
            userToUpdateData.setGenero(usuario.getGenero());
            userToUpdateData.setSenha(usuario.getSenha());
            userToUpdateData.setCategoriaUsuario(usuario.getCategoriaUsuario());
            userToUpdateData.setTelefone(usuario.getTelefone());
        }
    

        return usuarioRepository.saveAndFlush(usuario);
    }
    
    
    public Usuario loginUsuario(String email, String senha) {
        
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);

        
        if (usuarioOpt.isEmpty()) {
            throw new IllegalArgumentException("Usuário não encontrado!");
        }
        
        Usuario usuario = usuarioOpt.get();

        
        if (!usuario.getSenha().equals(senha)) { 
            throw new IllegalArgumentException("Senha inválida!");
        }

        return usuario; 

}
}