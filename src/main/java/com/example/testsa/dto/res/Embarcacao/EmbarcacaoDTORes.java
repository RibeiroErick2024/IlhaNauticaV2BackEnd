package com.example.testsa.dto.res.Embarcacao;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.example.testsa.dto.res.EnderecoDTORes;
import com.example.testsa.dto.res.ImagemEmbarcacaoDTORes;


public class EmbarcacaoDTORes {
    
    private UUID id_embarcacao;

    private String nome;

    private LocalDate anoFabricacao;

    private Float tamanho;

    private int capacidade;

    private String categoria;

    private String enderecoEmbarque;

    private Boolean disponibilidade;

    private Boolean pet;

    private int quantidadeBanheiro;

    private int quantidadeCabines;

    private String inscricao;

    private String bandeira;

    private EnderecoDTORes endereco;

    private List<ImagemEmbarcacaoDTORes> imagem;

    
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


    public UUID getId_embarcacao() {
        return id_embarcacao;
    }


    public void setId_embarcacao(UUID id_embarcacao) {
        this.id_embarcacao = id_embarcacao;
    }


    public EnderecoDTORes getEndereco() {
        return endereco;
    }


    public void setEndereco(EnderecoDTORes endereco) {
        this.endereco = endereco;
    }


    public List<ImagemEmbarcacaoDTORes> getImagem() {
        return imagem;
    }


    public void setImagem(List<ImagemEmbarcacaoDTORes> imagem) {
        this.imagem = imagem;
    }


  

}
