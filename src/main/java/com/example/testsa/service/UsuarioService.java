package com.example.testsa.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import com.example.testsa.converter.UsuarioConverter;
import com.example.testsa.dto.req.Usuario.UsuarioDTOReqs;
import com.example.testsa.dto.res.Usuario.UsuarioGeralDTORes;
import com.example.testsa.entities.Usuario;
import com.example.testsa.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;


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
    public UsuarioGeralDTORes editarUsuario(UUID id, UsuarioDTOReqs usuario) {

        Usuario userToUpdateData = buscarUsuarioPorId(id);

        userToUpdateData.setNomeCompleto(usuario.getNomeCompleto());
        userToUpdateData.setCpf(usuario.getCpf());
        userToUpdateData.setEmail(usuario.getEmail());
        userToUpdateData.setGenero(usuario.getGenero());
        userToUpdateData.setSenha(usuario.getSenha());
        userToUpdateData.setCategoriaUsuario(usuario.getCategoriaUsuario());
        userToUpdateData.setTelefone(usuario.getTelefone());
        Usuario usuarioAtualizado = usuarioRepository.saveAndFlush(userToUpdateData);
        return UsuarioConverter.usuarioConverterGeral(usuarioAtualizado);

    }

    @Transactional
    public UsuarioGeralDTORes completarUsuario(UUID id, UsuarioDTOReqs usuario) {
        Usuario userToUpdateData = buscarUsuarioPorId(id);
        userToUpdateData.setCpf(usuario.getCpf());
        userToUpdateData.setDataNascimento(usuario.getDataNascimento());
        userToUpdateData.setNomeCompleto(usuario.getNomeCompleto());
        userToUpdateData.setGenero(usuario.getGenero());
        userToUpdateData.setCategoriaUsuario("GERAL");
        userToUpdateData.setTelefone(usuario.getTelefone());
        Usuario usuarioAtualizado = usuarioRepository.saveAndFlush(userToUpdateData);
        return  UsuarioConverter.usuarioConverterGeral(usuarioAtualizado);
    }

    @Transactional
    public Usuario cadastroLocador(UUID id, Usuario usuario) {

        Usuario userToUpdateData = buscarUsuarioPorId(id);
        // userToUpdateData.setCpf(usuario.getCpf());
        // userToUpdateData.setNomeCompleto(usuario.getNomeCompleto());
        // userToUpdateData.setGenero(usuario.getGenero());
        userToUpdateData.setCategoriaUsuario("LOCADOR");
        // userToUpdateData.setTelefone(usuario.getTelefone());
        return usuarioRepository.saveAndFlush(userToUpdateData);
    }
    @Transactional
    public void deletarUsuario(UUID id) {
        
        usuarioRepository.findById(id)
                .orElseThrow(() -> new BadCredentialsException("Usuario não encontrado com id " + id));

        usuarioRepository.deleteById(id);

    }
    

    public Usuario loginUsuario(String email, String senha) {


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

}