package com.example.testsa.dto.res.Usuario;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.example.testsa.dto.res.Marinheiro.MarinheiroDTORes;

public class UsuarioLocadorDTORes {
    
    private UUID id;

	private String nomeCompleto;

	private String cpf;

	private LocalDate dataNascimento;

	private String genero;

	private String telefone;

	private String email;

	private String senha;

	private String categoriaUsuario;

	private List<MarinheiroDTORes> marinheiro;

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

    public List<MarinheiroDTORes> getMarinheiro() {
        return marinheiro;
    }

    public void setMarinheiro(List<MarinheiroDTORes> marinheiro) {
        this.marinheiro = marinheiro;
    }

   
  
    
}
