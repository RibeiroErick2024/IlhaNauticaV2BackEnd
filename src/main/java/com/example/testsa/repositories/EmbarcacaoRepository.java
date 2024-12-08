package com.example.testsa.repositories;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.testsa.entities.Embarcacao;

public interface EmbarcacaoRepository  extends JpaRepository<Embarcacao, UUID>{
      @Query("SELECT e FROM Embarcacao e JOIN FETCH e.usuario WHERE e.idEmbarcacao = :id")
    Embarcacao findByIdWithUsuario(@Param("id") UUID id);
}
