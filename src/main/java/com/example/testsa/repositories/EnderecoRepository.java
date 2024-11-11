package com.example.testsa.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testsa.entities.Endereco;

public interface EnderecoRepository extends JpaRepository <Endereco, UUID> {
    List<Endereco> findByEmbarcacaoIdEmbarcacao(UUID idEmbarcacao);
    List<Endereco> findByUsuarioId(UUID idUsuario);

}
