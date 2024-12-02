package com.example.testsa.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testsa.entities.Embarcacao;
import com.example.testsa.entities.Endereco;
import com.example.testsa.entities.Usuario;
import com.example.testsa.repositories.EmbarcacaoRepository;
import com.example.testsa.repositories.EnderecoRepository;
import com.example.testsa.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    EmbarcacaoRepository embarcacaoRepository;

    @Transactional
    public Endereco adicionarEndereco(Endereco endereco) {

        return enderecoRepository.saveAndFlush(endereco);
    }

    @Transactional
    public Endereco adicionarEnderecoUsuario(Endereco endereco) {

        if (endereco.getLatitude() == 0f || endereco.getLongitude() == 0f) {
            endereco.setLatitude(0f);
            endereco.setLongitude(0f);
        }

        if (endereco.getUsuario() == null || endereco.getUsuario().getId() == null) {
            throw new IllegalArgumentException("Por favor, forneça um Usuário ID para ao endereço.");
        }

        Usuario usuario = usuarioRepository.findById(endereco.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        endereco.setUsuario(usuario);

        return enderecoRepository.saveAndFlush(endereco);
    }

    @Transactional
    public Endereco adicionarEnderecoEmbarcacao(Endereco endereco) {

        if (endereco.getLatitude() == 0f || endereco.getLongitude() == 0f) {
            endereco.setLatitude(0f);
            endereco.setLongitude(0f);
        }

        if (endereco.getEmbarcacao() == null || endereco.getEmbarcacao().getIdEmbarcacao() == null) {
            throw new IllegalArgumentException("Por favor, forneça o ID da Embarcacao para associar ao endereço.");
        }

        Embarcacao embarcacao = embarcacaoRepository.findById(endereco.getEmbarcacao().getIdEmbarcacao())
                .orElseThrow(() -> new RuntimeException("Embarcação não encontrada no banco de dados."));

        endereco.setEmbarcacao(embarcacao);

        return enderecoRepository.saveAndFlush(endereco);
    }

    @Transactional
    public List<Endereco> buscarTodos() {
        return enderecoRepository.findAll();
    }

    @Transactional

    public List<Endereco> buscarPorIdEmbarcacao(UUID id) {

        List<Endereco> enderecos = enderecoRepository.findByEmbarcacaoIdEmbarcacao(id);

        return enderecos;
    }

    @Transactional
    public List<Endereco> buscarPorIdUsuario(UUID id) {

        List<Endereco> enderecos = enderecoRepository.findByUsuarioId(id);

        return enderecos;
    }

    @Transactional
    public Endereco atualizarEndereco(UUID id, Endereco endereco) {
        Optional<Endereco> enderecoExiste = enderecoRepository.findById(id);

        if (enderecoExiste.isPresent()) {
            Endereco enderecoAtualizado = enderecoExiste.get();
            enderecoAtualizado.setRua(endereco.getRua());
            enderecoAtualizado.setCidade(endereco.getCidade());
            enderecoAtualizado.setBairro(endereco.getBairro());
            enderecoAtualizado.setComplemento(endereco.getComplemento());
            enderecoAtualizado.setEstado(endereco.getEstado());
        
            enderecoAtualizado.setNumero(endereco.getNumero());

        }

        return enderecoRepository.saveAndFlush(endereco);
    }

    public void deletarendereco(UUID id) {

        enderecoRepository.deleteById(id);

    }
    

}
// @Transactional