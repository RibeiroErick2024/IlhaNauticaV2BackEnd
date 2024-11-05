package com.example.testsa.dto.res;

import java.math.BigDecimal;
import java.util.UUID;

public class AvaliacaoDTORes {
    

    private UUID id_avaliacao;

    private String comentario ;

    private BigDecimal  notaMarinheiro  ;

    private BigDecimal  notaEmbarcacao   ;

    private BigDecimal  notaAgendamento    ;

    public UUID getId_avaliacao() {
        return id_avaliacao;
    }

    public void setId_avaliacao(UUID id_avaliacao) {
        this.id_avaliacao = id_avaliacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public BigDecimal getNotaMarinheiro() {
        return notaMarinheiro;
    }

    public void setNotaMarinheiro(BigDecimal notaMarinheiro) {
        this.notaMarinheiro = notaMarinheiro;
    }

    public BigDecimal getNotaEmbarcacao() {
        return notaEmbarcacao;
    }

    public void setNotaEmbarcacao(BigDecimal notaEmbarcacao) {
        this.notaEmbarcacao = notaEmbarcacao;
    }

    public BigDecimal getNotaAgendamento() {
        return notaAgendamento;
    }

    public void setNotaAgendamento(BigDecimal notaAgendamento) {
        this.notaAgendamento = notaAgendamento;
    }



    
}
