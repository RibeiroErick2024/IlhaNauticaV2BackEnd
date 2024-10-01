package com.example.testsa.dto;

import java.sql.Date;
import java.util.UUID;

import com.example.testsa.entities.Marinheiro;
import com.example.testsa.entities.Usuario;

public class UsuarioDTO {
    
    private UUID id;

	private String nomeCompleto;

	private String cpf;

	private Date dataNascimento;

	private String genero;

	private String telefone;

	private String email;

	private String senha;

	private String categoriaUsuario;

	private Marinheiro marinheiro;

    

    public UsuarioDTO(Usuario usuario) {
        // this.nomeCompleto = nomeCompleto;
        // this.cpf = cpf;
        // this.dataNascimento = dataNascimento;
        // this.genero = genero;
        // this.telefone = telefone;
        // this.email = email;
        // this.senha = senha;
        // this.categoriaUsuario = categoriaUsuario;
    }

  

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCategoriaUsuario() {
        return categoriaUsuario;
    }

    public void setCategoriaUsuario(String categoriaUsuario) {
        this.categoriaUsuario = categoriaUsuario;
    }

    public Marinheiro getMarinheiro() {
        return marinheiro;
    }

    public void setMarinheiro(Marinheiro marinheiro) {
        this.marinheiro = marinheiro;
    }

    
}
