package com.example.testsa.dto.req;

public class CadastroDocumentoDTO {

    private String status;
    private byte[] documento;
    private String nome;

    // Construtor padrão
    public CadastroDocumentoDTO() {}

    // Getters e Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public byte[] getDocumento() {
        return documento;
    }

    public void setDocumento(byte[] documento) {
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
