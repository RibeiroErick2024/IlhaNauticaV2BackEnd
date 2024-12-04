package com.example.testsa.dto.res;

import java.util.UUID;

import com.example.testsa.dto.res.Usuario.UsuarioSimplesDTO;

public class AvaliacaoDTORes {
    

    private Long idAvaliacao;
    private String comentario;
    private int notaMarinheiro;
    private int notaEmbarcacao;
    private int notaAgendamento;
    private UsuarioSimplesDTO usuario;
    private UUID idMarinheiro;
    private UUID idEmbarcacao;
    private UUID idAgendamento;

    public Long getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Long idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

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

    public UsuarioSimplesDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioSimplesDTO usuario) {
        this.usuario = usuario;
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
