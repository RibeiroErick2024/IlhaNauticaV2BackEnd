package com.example.testsa.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testsa.entities.ImagemEmbarcacao;

public interface ImagemEmbarcacaoRepository extends JpaRepository <ImagemEmbarcacao, Long> {

        List<ImagemEmbarcacao> findByEmbarcacaoIdEmbarcacao(UUID idEmbarcacao);

} 