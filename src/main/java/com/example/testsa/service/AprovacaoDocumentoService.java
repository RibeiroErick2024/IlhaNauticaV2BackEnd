package com.example.testsa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testsa.entities.AprovacaoDocumento;
import com.example.testsa.entities.StatusAprovacaoEnum;
import com.example.testsa.repositories.AprovacaoDocumentoRepository;

@Service
public class AprovacaoDocumentoService {
    @Autowired
    AprovacaoDocumentoRepository aprovacaoDocumentoRepository;

    public String criarPendencia(AprovacaoDocumento doc) {
        AprovacaoDocumento pendencia = aprovacaoDocumentoRepository.save(doc);

        return "OI";
    }

    public List<AprovacaoDocumento> buscarPorStatusPendente() {
        List<AprovacaoDocumento> listaPendente = aprovacaoDocumentoRepository.findByStatusAprovacao("PENDENTE");
        return listaPendente;
    }

    public AprovacaoDocumento mudarStatus(AprovacaoDocumento doc, Long id){
         Optional<AprovacaoDocumento> buscadorDoc = aprovacaoDocumentoRepository.findByDocumentoIdDocumento(id);
        
        if(buscadorDoc.isPresent()){
            AprovacaoDocumento atualizarStatus = buscadorDoc.get();
            atualizarStatus.setStatusAprovacao(StatusAprovacaoEnum.APROVADO);
            return aprovacaoDocumentoRepository.saveAndFlush(atualizarStatus);
        }
    
        return null;

    }

}
