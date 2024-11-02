package com.example.testsa.entities;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;




@Entity
public class Agendamento {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_agendamento")
    private Long idAgendamento;

    @Column(name = "datainicio")
    private LocalDate dataInicio;

    @Column(name = "status")
    private String status;

    @Column(name = "datafinal")
    private LocalDate dataFinal;

    @OneToOne
    @JoinColumn(name = "fk_id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "fk_id_marinheiro", referencedColumnName = "id_marinheiro")
    private Marinheiro marinheiro;

    @OneToOne
    @JoinColumn(name = "fk_id_embarcacao", referencedColumnName = "id_embarcacao")
    private Embarcacao embarcacao;

    @OneToOne
    @JoinColumn(name = "fk_id_agendamento", referencedColumnName = "id_agendamento")
    private Avaliacao avaliacao;


    public Long getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(Long idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Marinheiro getMarinheiro() {
        return marinheiro;
    }

    public void setMarinheiro(Marinheiro marinheiro) {
        this.marinheiro = marinheiro;
    }

    public Embarcacao getEmbarcacao() {
        return embarcacao;
    }

    public void setEmbarcacao(Embarcacao embarcacao) {
        this.embarcacao = embarcacao;
    }

    public Iterable<Marinheiro> getMarinheiros() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

  
   



    


}
