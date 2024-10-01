package com.example.testsa.entities;

import java.sql.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// import com.github.f4b6a3.ulid.Ulid;
// import com.github.f4b6a3.ulid.UlidCreator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;

@Entity(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario", nullable = false)
	private UUID id;

	@Column(name = "nomeCompleto", length = 50, nullable = false)
	private String nomeCompleto;

	@Column(name = "cpf", length = 11, nullable = false)
	private String cpf;

	@Column(name = "dataNascimento")
	private Date dataNascimento;

	@Column(name = "genero")
	private String genero;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "email")
	private String email;

	@Column(name = "senha")
	private String senha;

	@Column(name = "categoria")
	private String categoriaUsuario;

	@OneToOne(mappedBy = "usuario", optional = true)
	private Marinheiro marinheiro;

	public Usuario() {

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

	// Getters and setters
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Marinheiro getMarinheiro() {
		return marinheiro;
	}

	public void setMarinheiro(Marinheiro marinheiro) {
		this.marinheiro = marinheiro;
	}

}
