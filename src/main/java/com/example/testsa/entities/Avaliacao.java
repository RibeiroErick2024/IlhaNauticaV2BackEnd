package com.example.testsa.entities;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "avaliacao")
public class Avaliacao {
    
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_avaliacao")
    private Long idAvaliacao;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "notamarinheiro")
    private int notaMarinheiro;

    @Column(name = "notaembarcacao")
    private int notaEmbarcacao;

    @Column(name = "notaagendamento")
    private int notaAgendamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_usuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_marinheiro")
    private Marinheiro marinheiro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_embarcacao")
    private Embarcacao embarcacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_agendamento")
    private Agendamento agendamento;

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

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

   

}
