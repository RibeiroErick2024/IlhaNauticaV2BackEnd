package com.example.testsa.dto.res;

import java.time.LocalDate;

import com.example.testsa.entities.StatusAprovacaoEnum;

public class AprovacaoDocumentoDTO {

    private Long idAprovacao;

    private LocalDate dataAprovacao;

    private String observacoes;

    private StatusAprovacaoEnum statusAprovacao;

    private DocumentosDTORes documento;

    public Long getIdAprovacao() {
        return idAprovacao;
    }

    public void setIdAprovacao(Long idAprovacao) {
        this.idAprovacao = idAprovacao;
    }

    public LocalDate getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(LocalDate dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public StatusAprovacaoEnum getStatusAprovacao() {
        return statusAprovacao;
    }

    public void setStatusAprovacao(StatusAprovacaoEnum statusAprovacao) {
        this.statusAprovacao = statusAprovacao;
    }

    public DocumentosDTORes getDocumento() {
        return documento;
    }

    public void setDocumento(DocumentosDTORes documento) {
        this.documento = documento;
    }

}
