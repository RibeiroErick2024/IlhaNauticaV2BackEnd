package com.example.testsa.service;

import com.example.testsa.converter.AvaliacaoConverter;
import com.example.testsa.dto.req.AvaliacaoDTOReq;
import com.example.testsa.dto.res.AvaliacaoDTORes;
import com.example.testsa.entities.Avaliacao;
import com.example.testsa.repositories.AvaliacaoRepository;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;
   
    @Transactional
    public AvaliacaoDTORes salvarAvaliacao(AvaliacaoDTOReq avaliacaoDTO) {
        Avaliacao avaliacao = AvaliacaoConverter.avaliacaoConverterEntidade(avaliacaoDTO);
        Avaliacao avaliacaoSalva = avaliacaoRepository.save(avaliacao);
        return AvaliacaoConverter.entidadetoDTO(avaliacaoSalva);
    }
 
    @Transactional
    public List<AvaliacaoDTORes> buscarTodos() {
        List<Avaliacao> avaliacao = avaliacaoRepository.findAll();
        List<AvaliacaoDTORes> todas = avaliacao.stream().map(a -> AvaliacaoConverter.entidadetoDTO(a)).toList();
        return todas;
    }
}