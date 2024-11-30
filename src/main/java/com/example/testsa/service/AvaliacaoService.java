package com.example.testsa.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import com.example.testsa.converter.AvaliacaoConverter;
import com.example.testsa.dto.res.AvaliacaoDTORes;
import com.example.testsa.entities.Avaliacao;
import com.example.testsa.repositories.AvaliacaoRepository;
import com.example.testsa.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    
    @Autowired
    private UsuarioRepository usuarioRepository;
   
    @Transactional
    public AvaliacaoDTORes salvarAvaliacao(Avaliacao avaliacao) {

        if (avaliacao.getUsuario().getId() != null) {
        usuarioRepository.findById(avaliacao.getUsuario().getId())
            .orElseThrow(() -> new BadCredentialsException("Usuário com este id não encontrado"));
        }
        Avaliacao avaliacaoSalva = avaliacaoRepository.save(avaliacao);
        AvaliacaoDTORes a = AvaliacaoConverter.entidadeConverterDTO(avaliacaoSalva);
        return a;
        
    }
 
    @Transactional
    public List<AvaliacaoDTORes> buscarTodos() {
        List<Avaliacao> avaliacao = avaliacaoRepository.findAll();
        List<AvaliacaoDTORes> todas = avaliacao.stream().map(a -> AvaliacaoConverter.entidadeConverterDTO(a)).toList();
        return todas;
    }
 
    @Transactional
      public List<AvaliacaoDTORes> buscarPorEmbarcacao(UUID idEmbarcacao) {
        List<Avaliacao> lista = avaliacaoRepository.findByEmbarcacaoIdEmbarcacao(idEmbarcacao);
        List<AvaliacaoDTORes> todas = lista.stream().map(a -> AvaliacaoConverter.entidadeConverterDTO(a)).toList();
        return todas;
    }

    @Transactional
    public void deleteAvaliacao(Long id) {
       avaliacaoRepository.deleteById(id);
    }

}