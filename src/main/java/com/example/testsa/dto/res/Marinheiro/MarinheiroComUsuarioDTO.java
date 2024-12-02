package com.example.testsa.dto.res.Marinheiro;

import java.time.LocalDate;
import java.util.UUID;

import com.example.testsa.dto.res.Usuario.UsuarioSimplesDTO;

public class MarinheiroComUsuarioDTO{

     private UUID idMarinheiro;

    private String nome;

    private String categoria;

    private String registroMaritimo;

    private String disponibilidade;

    private String cpf;

    private LocalDate dataNascimento;

    private String genero;

    private String telefone;

    private String email;

    private UsuarioSimplesDTO usuario;


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
