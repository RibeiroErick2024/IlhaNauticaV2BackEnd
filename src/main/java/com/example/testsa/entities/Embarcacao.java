package com.example.testsa.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity(name = "embarcacao")
public class Embarcacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_embarcacao")
    private UUID idEmbarcacao;

    @Column(name = "nome")
    private String nome;

    @Column(name = "anofabricacao")
    private int anoFabricacao;

    @Column(name = "fabricante")
    private String fabricante;

    @Column(name = "preco")
    private float preco;

    @Column(name = "potencia")
    private int potencia;

    @Column(name = "tamanho")
    private Float tamanho;

    @Column(name = "capacidade")
    private int capacidade;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "regras")
    private String regras;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "enderecoembarque")
    private String enderecoEmbarque;

    @Column(name = "disponibilidade")
    private Boolean disponibilidade;

    @Column(name = "pet")
    private Boolean pet;

    @Column(name = "quantidadebanheiro")
    private int quantidadeBanheiro;

    @Column(name = "quantidadecabines")
    private int quantidadeCabines;

    @Column(name = "inscricao_IMO")
    private String inscricao;

    @Column(name = "bandeira")
    private String bandeira;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "fk_id_endereco", referencedColumnName = "id_endereco")
    private Endereco endereco;

    @OneToMany(mappedBy = "embarcacao")
    private List<Avaliacao> avaliacao;
    
    @Lob
    @OneToMany(mappedBy = "embarcacao", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<ImagemEmbarcacao> imagem;

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

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
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

    public String getRegras() {
        return regras;
    }

    public void setRegras(String regras) {
        this.regras = regras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Avaliacao> getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(List<Avaliacao> avaliacao) {
        this.avaliacao = avaliacao;
    }

    public List<ImagemEmbarcacao> getImagem() {
        return imagem;
    }

    public void setImagem(List<ImagemEmbarcacao> imagem) {
        this.imagem = imagem;
    }

   

}
