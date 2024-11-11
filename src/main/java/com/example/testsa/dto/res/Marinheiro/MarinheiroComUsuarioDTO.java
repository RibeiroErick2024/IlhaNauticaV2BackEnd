package com.example.testsa.dto.res.Marinheiro;

import java.util.UUID;

import com.example.testsa.dto.res.Usuario.UsuarioSimplesDTO;

public class MarinheiroComUsuarioDTO{

    private UUID idMarinheiro;

    private String nome;

    private String categoria;

    private String registroMaritimo;

    private String disponibilidade;

    private int anosExperiencia;

    private UsuarioSimplesDTO usuario;


  

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


  

    public UsuarioSimplesDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioSimplesDTO usuario) {
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