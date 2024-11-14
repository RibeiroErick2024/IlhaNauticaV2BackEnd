package com.example.testsa.dto.res.Embarcacao;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.example.testsa.dto.res.EnderecoDTORes;
import com.example.testsa.dto.res.ImagemEmbarcacaoDTORes;

import jakarta.persistence.Column;

public class EmbarcacaoCardDTO {
    
    private UUID idEmbarcacao;
    
    private String nome;

    private int anoFabricacao;

    private String fabricante;
    
    private int potencia;

    private Float tamanho;

    private int capacidade;

    private String categoria;

    private int quantidadeCabines;
    
    private int quantidadeBanheiro;
      
    private Boolean pet;

    private float preco;

    private List<ImagemEmbarcacaoDTORes> imagem;

    private EnderecoDTORes endereco;
    

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

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
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

    public int getQuantidadeCabines() {
        return quantidadeCabines;
    }

    public void setQuantidadeCabines(int quantidadeCabines) {
        this.quantidadeCabines = quantidadeCabines;
    }

    public int getQuantidadeBanheiro() {
        return quantidadeBanheiro;
    }

    public void setQuantidadeBanheiro(int quantidadeBanheiro) {
        this.quantidadeBanheiro = quantidadeBanheiro;
    }

 
    public Boolean getPet() {
        return pet;
    }

    public void setPet(Boolean pet) {
        this.pet = pet;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }


    public EnderecoDTORes getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTORes endereco) {
        this.endereco = endereco;
    }

    public UUID getIdEmbarcacao() {
        return idEmbarcacao;
    }

    public void setIdEmbarcacao(UUID idEmbarcacao) {
        this.idEmbarcacao = idEmbarcacao;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public List<ImagemEmbarcacaoDTORes> getImagem() {
        return imagem;
    }

    public void setImagem(List<ImagemEmbarcacaoDTORes> imagem) {
        this.imagem = imagem;
    }



}
