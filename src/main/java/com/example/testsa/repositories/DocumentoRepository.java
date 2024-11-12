package com.example.testsa.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testsa.entities.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {
    List <Documento> findByUsuarioId(UUID idUsuario);
}
