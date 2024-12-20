package com.example.testsa.repositories;


import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testsa.entities.Embarcacao;

public interface EmbarcacaoRepository  extends JpaRepository<Embarcacao, UUID>{
    List<Embarcacao> findAllByUsuarioId(UUID idUsuario);
}
