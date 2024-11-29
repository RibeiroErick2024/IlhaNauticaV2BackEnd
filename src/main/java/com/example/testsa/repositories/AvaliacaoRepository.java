package com.example.testsa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testsa.entities.Avaliacao;


public interface AvaliacaoRepository  extends JpaRepository<Avaliacao, Long>{
    
}
