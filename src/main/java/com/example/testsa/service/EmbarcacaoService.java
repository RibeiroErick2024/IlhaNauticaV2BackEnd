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

    @Transactional
    public Embarcacao creatEmbarcacao(Embarcacao embarcacao) {
        return embarcacaoRepository.save(embarcacao);
    }

    public Embarcacao getEmbarcacaoById(UUID id_embarcacao) {
        Optional<Embarcacao> optEmbarcacao = embarcacaoRepository.findById(id_embarcacao);
        if (optEmbarcacao.isPresent()) {
            Embarcacao embarcacaoE = optEmbarcacao.get();
            return embarcacaoE;
        }
        return null;
    }




    @Transactional
    public Embarcacao updateEmbarcacao(UUID id_embarcacao, Embarcacao updateEmbarcacao) {
        Optional<Embarcacao> optionalEmbarcacao  = embarcacaoRepository.findById(id_embarcacao);

        if (optionalEmbarcacao.isPresent()) {
            Embarcacao embarcacaoToUpdate = optionalEmbarcacao.get();

            embarcacaoToUpdate.setNome(updateEmbarcacao.getNome());
            embarcacaoToUpdate.setAnoFabricacao(updateEmbarcacao.getAnoFabricacao());
            embarcacaoToUpdate.setTamanho(updateEmbarcacao.getTamanho());
            embarcacaoToUpdate.setCapacidade(updateEmbarcacao.getCapacidade());
            embarcacaoToUpdate.setCategoria(updateEmbarcacao.getCategoria());
            embarcacaoToUpdate.setEnderecoEmbarque(updateEmbarcacao.getEnderecoEmbarque());
            embarcacaoToUpdate.setDisponibilidade(updateEmbarcacao.getDisponibilidade());
            embarcacaoToUpdate.setImagem(updateEmbarcacao.getImagem());
            embarcacaoToUpdate.setPet(updateEmbarcacao.getPet());
            embarcacaoToUpdate.setQuantidadeBanheiro(updateEmbarcacao.getQuantidadeBanheiro());
            embarcacaoToUpdate.setQuantidadeCabines(updateEmbarcacao.getQuantidadeCabines());
            embarcacaoToUpdate.setInscricao(updateEmbarcacao.getInscricao());
            embarcacaoToUpdate.setBandeira(updateEmbarcacao.getBandeira());
            embarcacaoToUpdate.setUsuario(updateEmbarcacao.getUsuario());  
            // embarcacaoToUpdate.setEnderecos(updateEmbarcacao.getEnderecos());  

            // Salvando as atualizações

            return embarcacaoRepository.saveAndFlush(embarcacaoToUpdate);
        } else {
            throw new RuntimeException("Embarcação com ID" + id_embarcacao +  "não encontrada.");
        }
    }
        public void deleteEmbarcacao(UUID id_embarcacao) {
            if (embarcacaoRepository.existsById(id_embarcacao)) {
                embarcacaoRepository.deleteById(id_embarcacao);
            } else {
                throw new RuntimeException("Embarcação com ID " + id_embarcacao + " não encontrada.");
            }
    }

}
