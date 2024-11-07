package com.example.testsa.dto.res;


public class MarinheiroDTORes {
    
     private Long id_marinheiro;
    
    private String categoria;

    private String registroMaritimo;
   
    private String disponibilidade;

    private int anosExperiencia; 

    private UsuarioGeralDTORes usuario;

  
    public Long getId_marinheiro() {
        return id_marinheiro;
    }

    public void setId_marinheiro(Long id_marinheiro) {
        this.id_marinheiro = id_marinheiro;
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

    public UsuarioGeralDTORes getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioGeralDTORes usuario) {
        this.usuario = usuario;
    }

    

}
