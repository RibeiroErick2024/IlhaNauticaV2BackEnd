package com.example.testsa.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testsa.entities.Endereco;
import com.example.testsa.repositories.EnderecoRepository;

import jakarta.transaction.Transactional;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Transactional
    public Endereco adicionarEndereco(Endereco endereco) {

        // if (endereco.getLatitude() == null || endereco.getLongitude() == null) {
        // throw new IllegalArgumentException("Latitude e Longitude são obrigatórios.");
        // }

        // Usuario usuario = usuarioRepository.findById(endereco.getFk_id_usuario())
        // .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        // if (endereco.getFk_id_embarcacao() != null) {
        // Embarcacao embarcacao =
        // embarcacaoRepository.findById(endereco.getFk_id_embarcacao())
        // .orElseThrow(() -> new NotFoundException("Embarcação não encontrada"));
        // }

        return enderecoRepository.save(endereco);
    }

    @Transactional
    public List<Endereco> buscarTodos() {
        return enderecoRepository.findAll();
    }

    @Transactional
    public List<Endereco> buscarPorIdEmbarcacao(UUID id) {

        List<Endereco> enderecos = enderecoRepository.findByFkIdEmbarcacao(id);

        return enderecos;
    }

    @Transactional
    public List<Endereco> buscarPorIdUsuario(UUID id) {

        List<Endereco> enderecos = enderecoRepository.findByFkIdUsuario(id);

        return enderecos;
    }

    @Transactional
    public Endereco atualizarEndereco(UUID id, Endereco endereco) {
        Optional<Endereco> enderecoExiste = enderecoRepository.findById(id);

        if (enderecoExiste.isPresent()) {
            Endereco enderecoAtualizado = enderecoExiste.get();
            enderecoAtualizado.setRua(endereco.getRua());

        }

        return enderecoRepository.saveAndFlush(endereco);
    }

    public void deletarendereco(UUID id) {

        enderecoRepository.deleteById(id);

    }

}
