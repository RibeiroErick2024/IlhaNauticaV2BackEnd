package com.example.testsa.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testsa.entities.Agendamento;

public interface  AgendamentoRepository  extends JpaRepository<Agendamento, UUID>{
     List<Agendamento> findByUsuarioId(UUID idUsuario);
     List<Agendamento> findByEmbarcacaoIdEmbarcacao(UUID idEmbarcacao);
     List<Agendamento> findByMarinheiroIdMarinheiro(UUID idMarinheiro);
     void deleteByUsuarioId(UUID idUsuario);
     void deleteByEmbarcacaoIdEmbarcacao(UUID idEmbarcacao);
}
