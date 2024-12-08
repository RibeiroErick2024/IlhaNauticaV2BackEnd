package com.example.testsa.dto.res;

import com.example.testsa.dto.res.Usuario.UsuarioSimplesDTO;

public class DocumentosDTORes {

    private Long idDocumento;
    private String status;
    private byte[] documento;
    private String nome;
    private String formato;
    private UsuarioSimplesDTO usuario;

  
    public Long getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Long idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UsuarioSimplesDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioSimplesDTO usuario) {
        this.usuario = usuario;
    }

  

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public byte[] getDocumento() {
        return documento;
    }

    public void setDocumento(byte[] documento) {
        this.documento = documento;
    }

 
}
