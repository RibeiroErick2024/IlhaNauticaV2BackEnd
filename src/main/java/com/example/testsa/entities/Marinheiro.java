package com.example.testsa.entities;


import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "fk_id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "marinheiro")
	private List<Agendamento> agendamento;
    
    // @OneToMany(mappedBy = "marinheiro")
    // private List<Avaliacao> avaliacao;

    public UUID getIdMarinheiro() {
        return idMarinheiro;
    }

    public void setIdMarinheiro(UUID idMarinheiro) {
        this.idMarinheiro = idMarinheiro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Agendamento> getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(List<Agendamento> agendamento) {
        this.agendamento = agendamento;
    }

    // public List<Avaliacao> getAvaliacao() {
    //     return avaliacao;
    // }

    // public void setAvaliacao(List<Avaliacao> avaliacao) {
    //     this.avaliacao = avaliacao;
    // }   

   
}
