package com.example.testsa.converter;

import com.example.testsa.dto.res.AprovacaoDocumentoDTO;
import com.example.testsa.entities.AprovacaoDocumento;
import com.example.testsa.entities.Documentos;
import com.example.testsa.entities.StatusAprovacaoEnum;

public interface AprovacaoDocumentoConverter {
      
    public static AprovacaoDocumento docEntidadeParaEntidade(Documentos dto) {
        AprovacaoDocumento entity = new AprovacaoDocumento();
        entity.setUsuario(dto.getUsuario());
        entity.setDocumento(dto);
        entity.setStatusAprovacao(StatusAprovacaoEnum.PENDENTE);
        return entity;
    }

    public static AprovacaoDocumentoDTO entidadeParaDTO (AprovacaoDocumento entidade){
        AprovacaoDocumentoDTO dto = new AprovacaoDocumentoDTO();
        dto.setIdAprovacao(entidade.getIdAprovacao());
        dto.setDataAprovacao(entidade.getDataAprovacao());
        dto.setObservacoes(entidade.getObservacoes());
        dto.setStatusAprovacao(entidade.getStatusAprovacao());
        dto.setDocumento(DocumentoConverter.entidadeParaDto(entidade.getDocumento()));
        return dto;
    }
}
