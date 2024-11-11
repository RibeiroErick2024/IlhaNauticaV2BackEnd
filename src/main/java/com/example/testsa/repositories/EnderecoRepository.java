package com.example.testsa.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testsa.entities.Endereco;

public interface EnderecoRepository extends JpaRepository <Endereco, UUID> {
    // List<Endereco> findById_Embarcacao(UUID id_endereco);
    // List<Endereco> findById_Usuario(UUID id_endereco);

}
