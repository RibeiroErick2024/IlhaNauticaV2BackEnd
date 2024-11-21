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

    @Autowired
    EnderecoService enderecoService;

    public List<Usuario> buscarTodosUsuario() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public Usuario criarUsuario(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }

    @Transactional
    public Usuario buscarUsuarioPorId(UUID id) {

        Optional<Usuario> optUsuario = usuarioRepository.findById(id);
        if (optUsuario.isPresent()) {
            Usuario usuarioEncontrado = optUsuario.get();
            return usuarioEncontrado;
        }

        throw new IllegalArgumentException("Usuário não encontrado com esse" + id);

    }

    @Transactional
    public Usuario editarUsuario(UUID id, Usuario usuario) {

        Usuario userToUpdateData = buscarUsuarioPorId(id);

        userToUpdateData.setNomeCompleto(usuario.getNomeCompleto());
        userToUpdateData.setCpf(usuario.getCpf());
        userToUpdateData.setEmail(usuario.getEmail());
        userToUpdateData.setGenero(usuario.getGenero());
        userToUpdateData.setSenha(usuario.getSenha());
        userToUpdateData.setCategoriaUsuario(usuario.getCategoriaUsuario());
        userToUpdateData.setTelefone(usuario.getTelefone());
        Usuario usuarioAtualizado = usuarioRepository.saveAndFlush(userToUpdateData);
        return usuarioAtualizado;

    }

    @Transactional
    public Usuario completarUsuario(UUID id, Usuario usuario) {
       System.out.println(usuario.getEndereco().getBairro());
        Usuario userToUpdateData = buscarUsuarioPorId(id);
        userToUpdateData.setCpf(usuario.getCpf());
        userToUpdateData.setDataNascimento(usuario.getDataNascimento());
        userToUpdateData.setNomeCompleto(usuario.getNomeCompleto());
        userToUpdateData.setGenero(usuario.getGenero());
        userToUpdateData.setCategoriaUsuario("GERAL");
        userToUpdateData.setTelefone(usuario.getTelefone());
        Usuario usuarioAtualizado = usuarioRepository.saveAndFlush(userToUpdateData);
        return usuarioAtualizado;
    }
    @Transactional
    public Usuario cadastroLocador(UUID id, Usuario usuario) {
       
        Usuario userToUpdateData = buscarUsuarioPorId(id);
        userToUpdateData.setCpf(usuario.getCpf());
        userToUpdateData.setNomeCompleto(usuario.getNomeCompleto());
        userToUpdateData.setGenero(usuario.getGenero());
        userToUpdateData.setCategoriaUsuario("GERAL");
        userToUpdateData.setTelefone(usuario.getTelefone());
        return usuarioRepository.saveAndFlush(userToUpdateData);
    }

    public void deletarUsuario(UUID id) {
        usuarioRepository.findById(id).orElseThrow();

        usuarioRepository.deleteById(id);
    }

    public Usuario loginUsuario(String email, String senha) {
<<<<<<< HEAD
        // Tenta encontrar o usuário pelo email
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);
    
        // Verifica se o usuário não foi encontrado
        if (usuarioOpt.isEmpty()) {
            throw new IllegalArgumentException("Usuário não encontrado!");
        }
    
        // Se o usuário foi encontrado, obtemos o objeto
        Usuario usuario = usuarioOpt.get();
    
        // Verifica se a senha está correta
        if (!usuario.getSenha().equals(senha)) {
            throw new IllegalArgumentException("Senha inválida!");
        }
    
        return usuario;
    }
    
=======

        Optional<Usuario> usuarioOpt = Optional.ofNullable(usuarioRepository.findByEmail(email).orElseThrow());

        if (usuarioOpt.isEmpty()) {
            throw new IllegalArgumentException("Usuário não encontrado!");
        }

        Usuario usuario = usuarioOpt.get();

        if (!usuario.getSenha().equals(senha)) {
            throw new IllegalArgumentException("Senha inválida!");
        }

        return usuario;

    }
>>>>>>> 2e2e6ab3afd9d027d69c9feda4d337efac1e83c3
}