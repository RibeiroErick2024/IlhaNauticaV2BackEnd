package com.example.testsa.dto.res;

import java.time.LocalDate;


public class EmbarcacaoDTORes {
    
    private Long id_embarcacao;

    private String nome;

    private LocalDate anoFabricacao;

    private Float tamanho;

    private int capacidade;

    private String categoria;

    private String enderecoEmbarque;

    private Boolean disponibilidade;

    private String imagem;

    private Boolean pet;

    private int quantidadeBanheiro;

    private int quantidadeCabines;

    private String inscricao;

    private String bandeira;

    public Long getId_embarcacao() {
        return id_embarcacao;
    }


    public void setId_embarcacao(Long id_embarcacao) {
        this.id_embarcacao = id_embarcacao;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public LocalDate getAnoFabricacao() {
        return anoFabricacao;
    }


    public void setAnoFabricacao(LocalDate anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
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


    public String getEnderecoEmbarque() {
        return enderecoEmbarque;
    }


    public void setEnderecoEmbarque(String enderecoEmbarque) {
        this.enderecoEmbarque = enderecoEmbarque;
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


    public int getQuantidadeBanheiro() {
        return quantidadeBanheiro;
    }


    public void setQuantidadeBanheiro(int quantidadeBanheiro) {
        this.quantidadeBanheiro = quantidadeBanheiro;
    }


    public int getQuantidadeCabines() {
        return quantidadeCabines;
    }


    public void setQuantidadeCabines(int quantidadeCabines) {
        this.quantidadeCabines = quantidadeCabines;
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


  

}
