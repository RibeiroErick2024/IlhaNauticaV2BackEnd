package com.example.testsa.dto.req;

import java.util.UUID;

public class EmbarcacaoDTOReq {
    
    private UUID idEmbarcacao;

    private String nome;

    public UUID getIdEmbarcacao() {
        return idEmbarcacao;
    }

    public void setIdEmbarcacao(UUID id_embarcacao) {
        this.idEmbarcacao = id_embarcacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
