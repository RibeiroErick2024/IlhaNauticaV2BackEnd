package com.example.testsa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testsa.entities.Embarcacao;

public interface EmbarcacaoRepository  extends JpaRepository<Embarcacao, Long>{
    
}
