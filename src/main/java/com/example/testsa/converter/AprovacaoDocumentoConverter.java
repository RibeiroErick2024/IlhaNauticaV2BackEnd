package com.example.testsa.converter;

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
}
