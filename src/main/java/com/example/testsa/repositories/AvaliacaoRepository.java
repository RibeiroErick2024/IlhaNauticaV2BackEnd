package com.example.testsa.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testsa.entities.Avaliacao;


public interface AvaliacaoRepository  extends JpaRepository<Avaliacao, Long>{
        List<Avaliacao> findByEmbarcacaoIdEmbarcacao(UUID idEmbarcacao);
}
