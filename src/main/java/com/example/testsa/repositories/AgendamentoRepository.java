package com.example.testsa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testsa.entities.Agendamento;

public interface  AgendamentoRepository  extends JpaRepository<Agendamento, Long>{
    
}
