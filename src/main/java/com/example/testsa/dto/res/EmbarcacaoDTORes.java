package com.example.testsa.dto.res;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.example.testsa.entities.Endereco;
import com.example.testsa.entities.Usuario;

public class EmbarcacaoDTORes {
    private UUID id_embarcacao;

    private String nome;

    private LocalDate anofabricacao;

    private Float tamanho;

    private int capacidade;

    private String categoria;

    private String enderecoembarque;

    private Boolean disponibilidade;

    private String imagem;

    private Boolean pet;

    private int quantidadebanheiro;

    private int quantidadecabines;

    private String inscricao;

    private String bandeira;

    private Usuario usuario;

    private List<Endereco> enderecos;

    public UUID getId_embarcacao() {
        return id_embarcacao;
    }

    public void setId_embarcacao(UUID id_embarcacao) {
        this.id_embarcacao = id_embarcacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getAnofabricacao() {
        return anofabricacao;
    }

    public void setAnofabricacao(LocalDate anofabricacao) {
        this.anofabricacao = anofabricacao;
    }

    public Float getTamanho() {
        return tamanho;
    }

    public void setTamanho(Float tamanho) {
        this.tamanho = tamanho;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEnderecoembarque() {
        return enderecoembarque;
    }

    public void setEnderecoembarque(String enderecoembarque) {
        this.enderecoembarque = enderecoembarque;
    }

    public Boolean getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Boolean getPet() {
        return pet;
    }

    public void setPet(Boolean pet) {
        this.pet = pet;
    }

    public int getQuantidadebanheiro() {
        return quantidadebanheiro;
    }

    public void setQuantidadebanheiro(int quantidadebanheiro) {
        this.quantidadebanheiro = quantidadebanheiro;
    }

    public int getQuantidadecabines() {
        return quantidadecabines;
    }

    public void setQuantidadecabines(int quantidadecabines) {
        this.quantidadecabines = quantidadecabines;
    }

    public String getInscricao() {
        return inscricao;
    }

    public void setInscricao(String inscricao) {
        this.inscricao = inscricao;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

}
