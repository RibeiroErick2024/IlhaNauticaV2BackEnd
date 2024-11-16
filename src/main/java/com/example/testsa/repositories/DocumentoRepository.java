package com.example.testsa.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.testsa.entities.Documentos;

@Repository
public interface DocumentoRepository extends JpaRepository<Documentos, Long> {
    List <Documentos> findByUsuarioId(UUID idUsuario);
}
