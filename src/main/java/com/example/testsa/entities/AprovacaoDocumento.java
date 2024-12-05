package com.example.testsa.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity (name = "aprovacaodocumento")
public class AprovacaoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aprovacao")
    private Long idAprovacao;

    @Column(name = "data_aprovacao")
    private LocalDate dataAprovacao;

    @Column(name = "observacoes")
    private String observacoes;

    // Utilizando o enum StatusAprovacao
    @Enumerated(EnumType.STRING) // Armazena o valor como string no banco
    @Column(name = "status_aprovacao", nullable = false)
    private StatusAprovacaoEnum statusAprovacao;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "fk_id_documento", referencedColumnName = "id_documento")
    private Documentos documento;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "fk_id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    public Long getIdAprovacao() {
        return idAprovacao;
    }

    public void setIdAprovacao(Long idAprovacao) {
        this.idAprovacao = idAprovacao;
    }

    public LocalDate getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(LocalDate dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public StatusAprovacaoEnum getStatusAprovacao() {
        return statusAprovacao;
    }

    public void setStatusAprovacao(StatusAprovacaoEnum statusAprovacao) {
        this.statusAprovacao = statusAprovacao;
    }

    public Documentos getDocumento() {
        return documento;
    }

    public void setDocumento(Documentos documento) {
        this.documento = documento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    

}
