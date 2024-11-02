package com.example.testsa.dto.req;

import java.math.BigDecimal;
import java.util.UUID;

import com.example.testsa.entities.Agendamento;
import com.example.testsa.entities.Embarcacao;
import com.example.testsa.entities.Marinheiro;

public class AvaliacaoDTO {
    
     private UUID id_avaliacao;

    private String comentario ;

    private Marinheiro  notaMarinheiro  ;

    private Embarcacao  notaEmbarcacao   ;

    private Agendamento  notaAgendamento    ;

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

    public Marinheiro getNotaMarinheiro() {
        return notaMarinheiro;
    }

    public void setNotaMarinheiro(Marinheiro notaMarinheiro) {
        this.notaMarinheiro = notaMarinheiro;
    }

    public Embarcacao getNotaEmbarcacao() {
        return notaEmbarcacao;
    }

    public void setNotaEmbarcacao(Embarcacao notaEmbarcacao) {
        this.notaEmbarcacao = notaEmbarcacao;
    }

    public Agendamento getNotaAgendamento() {
        return notaAgendamento;
    }

    public void setNotaAgendamento(Agendamento notaAgendamento) {
        this.notaAgendamento = notaAgendamento;
    }

    



    
}
