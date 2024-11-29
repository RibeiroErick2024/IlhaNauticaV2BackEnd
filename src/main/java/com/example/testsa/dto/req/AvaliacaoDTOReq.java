package com.example.testsa.dto.req;

import java.util.UUID;

public class AvaliacaoDTOReq {

    private String comentario;
    private int notaMarinheiro;
    private int notaEmbarcacao;
    private int notaAgendamento;
    private UUID idUsuario;
    private UUID idMarinheiro;
    private UUID idEmbarcacao;
    private UUID idAgendamento;

    // Getters and Setters
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getNotaMarinheiro() {
        return notaMarinheiro;
    }

    public void setNotaMarinheiro(int notaMarinheiro) {
        this.notaMarinheiro = notaMarinheiro;
    }

    public int getNotaEmbarcacao() {
        return notaEmbarcacao;
    }

    public void setNotaEmbarcacao(int notaEmbarcacao) {
        this.notaEmbarcacao = notaEmbarcacao;
    }

    public int getNotaAgendamento() {
        return notaAgendamento;
    }

    public void setNotaAgendamento(int notaAgendamento) {
        this.notaAgendamento = notaAgendamento;
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

    public UUID getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(UUID idAgendamento) {
        this.idAgendamento = idAgendamento;
    }
}