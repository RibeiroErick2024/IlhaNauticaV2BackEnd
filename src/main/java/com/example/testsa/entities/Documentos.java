package com.example.testsa.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name="documentos")
public class Documentos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_documento")
    private Long idDocumento;

    @Column(name = "status")
    private String status;
    
    @Lob
    @Column(name = "documento", columnDefinition = "BYTEA")
    private byte[] documento;

    @Column(name = "nome")
    private String nome;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "fk_id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

   	@OneToMany(mappedBy = "documento")
	private List<AprovacaoDocumento> AprovacaoDocumento;
   
    @Column(name = "formato")
    private String formato;

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<AprovacaoDocumento> getAprovacaoDocumento() {
        return AprovacaoDocumento;
    }

    public void setAprovacaoDocumento(List<AprovacaoDocumento> aprovacaoDocumento) {
        AprovacaoDocumento = aprovacaoDocumento;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

  
    
}
