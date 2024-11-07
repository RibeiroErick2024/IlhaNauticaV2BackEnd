// package com.example.testsa.entities;

// import java.math.BigDecimal;
// import java.util.List;
// import java.util.UUID;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.OneToMany;

// @Entity
// public class Avaliacao {
    

//      @Id
//     @GeneratedValue(strategy = GenerationType.AUTO)
//     @Column(name = "id_avaliacao")
//     private UUID id_avaliacao;

//     @Column(name = "comentario ")
//     private String comentario ;

//     @Column(name = "notaMarinheiro  ")
//     private BigDecimal  notaMarinheiro  ;

//     @Column(name = "notaEmbarcacao   ")
//     private BigDecimal  notaEmbarcacao   ;

//     @Column(name = "notaAgendamento    ")
//     private BigDecimal  notaAgendamento    ;


//     @OneToMany(mappedBy = "avaliacao")
//     private List<Usuario> usuario;

//     @OneToMany(mappedBy = "avaliacao")
//     private List<Agendamento> agendamento;

//     @OneToMany(mappedBy = "avaliacao")
//     private List<Marinheiro> marinheiro;

//     @OneToMany(mappedBy = "avaliacao")
//     private List<Embarcacao> embarcacao;

//     public UUID getId_avaliacao() {
//         return id_avaliacao;
//     }

//     public void setId_avaliacao(UUID id_avaliacao) {
//         this.id_avaliacao = id_avaliacao;
//     }

//     public String getComentario() {
//         return comentario;
//     }

//     public void setComentario(String comentario) {
//         this.comentario = comentario;
//     }

//     public BigDecimal getNotaMarinheiro() {
//         return notaMarinheiro;
//     }

//     public void setNotaMarinheiro(BigDecimal notaMarinheiro) {
//         this.notaMarinheiro = notaMarinheiro;
//     }

//     public BigDecimal getNotaEmbarcacao() {
//         return notaEmbarcacao;
//     }

//     public void setNotaEmbarcacao(BigDecimal notaEmbarcacao) {
//         this.notaEmbarcacao = notaEmbarcacao;
//     }

//     public BigDecimal getNotaAgendamento() {
//         return notaAgendamento;
//     }

//     public void setNotaAgendamento(BigDecimal notaAgendamento) {
//         this.notaAgendamento = notaAgendamento;
//     }

//     public List<Usuario> getUsuario() {
//         return usuario;
//     }

//     public void setUsuario(List<Usuario> usuario) {
//         this.usuario = usuario;
//     }

//     public List<Agendamento> getAgendamento() {
//         return agendamento;
//     }

//     public void setAgendamento(List<Agendamento> agendamento) {
//         this.agendamento = agendamento;
//     }

//     public List<Marinheiro> getMarinheiro() {
//         return marinheiro;
//     }

//     public void setMarinheiro(List<Marinheiro> marinheiro) {
//         this.marinheiro = marinheiro;
//     }

//     public List<Embarcacao> getEmbarcacao() {
//         return embarcacao;
//     }

//     public void setEmbarcacao(List<Embarcacao> embarcacao) {
//         this.embarcacao = embarcacao;
//     }


// }
