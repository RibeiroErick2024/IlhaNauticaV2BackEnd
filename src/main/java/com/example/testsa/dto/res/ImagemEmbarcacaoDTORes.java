package com.example.testsa.dto.res;

public class ImagemEmbarcacaoDTORes {
   
    private Long id_imagem;
   
    private String nome;
    
    private byte[]imagem;
      
    private String formato;

    public Long getId_imagem() {
        return id_imagem;
    }

    public void setId_imagem(Long id_imagem) {
        this.id_imagem = id_imagem;
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


    public String getFormato() {
        return formato;
    }


    public void setFormato(String formato) {
        this.formato = formato;
    }

    
}
