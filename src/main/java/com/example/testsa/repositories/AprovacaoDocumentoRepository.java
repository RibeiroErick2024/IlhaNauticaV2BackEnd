package com.example.testsa.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testsa.entities.AprovacaoDocumento;

public interface AprovacaoDocumentoRepository extends JpaRepository<AprovacaoDocumento, Long>{
    List <AprovacaoDocumento> findByStatusAprovacao(String status);
    Optional<AprovacaoDocumento> findByDocumentoIdDocumento(Long idDocumento);
    List<AprovacaoDocumento> findByUsuarioId(UUID idUsuario);
}
