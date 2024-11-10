package com.example.testsa.dto.res;

import java.util.UUID;

public class EmbarcacaoSimplesDTORes {

     private UUID id_embarcacao;

    private String nome;

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

    
}
