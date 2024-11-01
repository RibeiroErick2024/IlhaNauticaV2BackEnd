package com.example.testsa.converter;

import com.example.testsa.dto.res.EmbarcacaoDTORes;
import com.example.testsa.entities.Embarcacao;

public class EmbarcacaoConverter {
     public static EmbarcacaoDTORes embarcacaoConverterDTO(Embarcacao embarcacao) {
        EmbarcacaoDTORes dto = new EmbarcacaoDTORes();
        dto.setId_embarcacao(embarcacao.getId_embarcacao());
        dto.setAnoFabricacao(embarcacao.getAnoFabricacao());
        // Continuar...
        return dto;
    }
}
