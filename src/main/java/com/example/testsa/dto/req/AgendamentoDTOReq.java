package com.example.testsa.dto.req;

import java.time.LocalDate;
import java.util.UUID;

public class AgendamentoDTOReq {

    private UUID idAgendamento;
    private LocalDate dataInicio;
    private String status;
    private LocalDate dataFinal;
    private UUID idUsuario;
    private UUID idMarinheiro;
    private UUID idEmbarcacao;

    // Getters and Setters
    public UUID getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(UUID idAgendamento) {
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

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UUID getIdMarinheiro() {
        return idMarinheiro;
    }

    public void setIdMarinheiro(UUID idMarinheiro) {
        this.idMarinheiro = idMarinheiro;
    }

    public UUID getIdEmbarcacao() {
        return idEmbarcacao;
    }

    public void setIdEmbarcacao(UUID idEmbarcacao) {
        this.idEmbarcacao = idEmbarcacao;
    }
}