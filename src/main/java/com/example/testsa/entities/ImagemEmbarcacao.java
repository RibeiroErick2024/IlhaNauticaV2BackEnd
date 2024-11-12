package com.example.testsa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity(name= "imagemembarcacao")
public class ImagemEmbarcacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagem")
    private Long idImagem;

    @Column(name = "nome")
    private String nome;
    
    @Lob
    @Column(name = "imagem")
    private byte[]imagem;
    
    @ManyToOne
    @JoinColumn(name = "fk_id_embarcacao")
    private Embarcacao embarcacao;

    @Column(name = "formato")
    private String formato;


    public Long getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(Long id_imagem) {
        this.idImagem = id_imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public Embarcacao getEmbarcacao() {
        return embarcacao;
    }

    public void setEmbarcacao(Embarcacao embarcacao) {
        this.embarcacao = embarcacao;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }


    
}
