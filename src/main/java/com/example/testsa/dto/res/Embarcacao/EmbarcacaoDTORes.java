package com.example.testsa.dto.res.Embarcacao;

import java.util.List;
import java.util.UUID;

import com.example.testsa.dto.res.EnderecoDTORes;
import com.example.testsa.dto.res.ImagemEmbarcacaoDTORes;

public class EmbarcacaoDTORes {

    private UUID idEmbarcacao;

    private String nome;

    private String fabricante;

    private int anoFabricacao;

    private Float tamanho;

    private int potencia;

    private int capacidade;

    private String categoria;

    private String enderecoEmbarque;

    private Boolean disponibilidade;

    private Boolean pet;

    private int quantidadeBanheiro;

    private int quantidadeCabines;

    private String inscricao;

    private String bandeira;

    private float preco;
    
    private EnderecoDTORes endereco;

    private List<ImagemEmbarcacaoDTORes> imagem;

    public UUID getIdEmbarcacao() {
        return idEmbarcacao;
    }

    public void setIdEmbarcacao(UUID idEmbarcacao) {
        this.idEmbarcacao = idEmbarcacao;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Float getTamanho() {
        return tamanho;
    }

    public void setTamanho(Float tamanho) {
        this.tamanho = tamanho;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
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

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

   
}
