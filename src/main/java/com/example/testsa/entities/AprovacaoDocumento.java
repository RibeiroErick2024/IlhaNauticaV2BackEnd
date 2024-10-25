package com.example.testsa.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class AprovacaoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aprovacao")
    private Long idAprovacao;

    @Column(name = "data_aprovacao")
    private Date data_aprovacao;

    @Column(name = "observacoes")
    private String observacoes;

    // Utilizando o enum StatusAprovacao
    @Enumerated(EnumType.STRING) // Armazena o valor como string no banco
    @Column(name = "status_aprovacao", nullable = false)
    private StatusAprovacaoEnum statusAprovacao;

    @OneToOne
    @JoinColumn(name = "fk_id_documento", referencedColumnName = "id_documento")
    private Documento documento;

    @OneToOne
    @JoinColumn(name = "fk_id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

}
