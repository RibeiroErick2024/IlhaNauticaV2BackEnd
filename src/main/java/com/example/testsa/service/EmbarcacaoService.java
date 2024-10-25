package com.example.testsa.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testsa.entities.Embarcacao;

import com.example.testsa.repositories.EmbarcacaoRepository;

import jakarta.transaction.Transactional;

@Service
public class EmbarcacaoService {
    
@Autowired
EmbarcacaoRepository embarcacaoRepository;

@Transactional
public List<Embarcacao> getAllEmbarcacaos() {
        return embarcacaoRepository.findAll();
    }

// public  Embarcacao getEmbarcacaoById (UUID id_embarcacao){
//     Optional<Embarcacao> optEmbarcacao = embarcacaoRepository.findById(id_embarcacao);
//     if (optEmbarcacao.isPresent()){
//         Embarcacao embarcacaoE = optEmbarcacao.get();
//         return embarcacaoE;
//     }
//     return null;
// }

@Transactional
public Embarcacao updatEmbarcacao(UUID id_embarcacao, Embarcacao embarcacao){
    Optional<Embarcacao> optionalEmbarcacao
}


}
