package com.example.testsa.entities;


import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "marinheiro")
public class Marinheiro {

    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_marinheiro")
    private UUID idMarinheiro;

    @Column(name = "nome")
    private String nome;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "registromaritimo")
    private String registroMaritimo;

    @Column(name = "disponibilidade")
    private String disponibilidade;

    //data Nascimento //cpf //genero //email //telefone
    @Column(name = "anosexperiencia")
    private int anosExperiencia;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "fk_id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "marinheiro")
	private List<Agendamento> agendamento;


    
    public List<Agendamento> getAgendamento() {
        return agendamento;
    }
    public void setAgendamento(List<Agendamento> agendamento) {
        this.agendamento = agendamento;
    }
    public Marinheiro(){

    }

  
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getRegistroMaritimo() {
        return registroMaritimo;
    }

    public void setRegistroMaritimo(String registroMaritimo) {
        this.registroMaritimo = registroMaritimo;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public int getAnosExperiencia() {
        return anosExperiencia;
    }

    public void setAnosExperiencia(int anosExperiencia) {
        this.anosExperiencia = anosExperiencia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
     public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public UUID getIdMarinheiro() {
        return idMarinheiro;
    }
    public void setIdMarinheiro(UUID idMarinheiro) {
        this.idMarinheiro = idMarinheiro;
    }

}
