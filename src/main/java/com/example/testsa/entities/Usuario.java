package com.example.testsa.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario")
	private UUID id;

	@Column(name = "nomecompleto", length = 50, nullable = false)
	private String nomeCompleto;

	@Column(name = "cpf_cnpj", length = 11)
	private String cpf;

	@Column(name = "datanascimento")
	private LocalDate dataNascimento;

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

	@OneToMany(mappedBy = "usuario")
	private List<Marinheiro> marinheiro;

	@OneToMany(mappedBy = "usuario")
	private List<Agendamento> agendamento;

	@OneToMany(mappedBy = "usuario")
	private List<Embarcacao> embarcacao;

	@OneToOne(mappedBy = "usuario")
	private Endereco endereco;


	public List<Agendamento> getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(List<Agendamento> agendamento) {
		this.agendamento = agendamento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

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

	// Getters and setters
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public List<Marinheiro> getMarinheiro() {
		return marinheiro;
	}

	public void setMarinheiro(List<Marinheiro> marinheiro) {
		this.marinheiro = marinheiro;
	}

    public List<Embarcacao> getEmbarcacao() {
        return embarcacao;
    }

    public void setEmbarcacao(List<Embarcacao> embarcacao) {
        this.embarcacao = embarcacao;
    }



}
