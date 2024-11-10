package com.example.testsa.dto.res.Usuario;

import java.util.UUID;

public class UsuarioSimplesDTO {
    
    private UUID id;

    private String nomeCompleto;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
    
}
