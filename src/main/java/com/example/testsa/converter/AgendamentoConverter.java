package com.example.testsa.converter;

import com.example.testsa.dto.res.AgendamentosDTORes;
import com.example.testsa.entities.Agendamento;

public class AgendamentoConverter {
    public static AgendamentosDTORes agendamentoConverterDTO(Agendamento agendamento) {
        AgendamentosDTORes dto = new AgendamentosDTORes();
        dto.setIdAgendamento(agendamento.getIdAgendamento());
        dto.setDataInicio(agendamento.getDataInicio());
        dto.setStatus(agendamento.getStatus());
        dto.setDataFinal(agendamento.getDataFinal());
        dto.setUsuario(UsuarioConverter.usuarioConverterSimples(agendamento.getUsuario()));
        dto.setMarinheiro(MarinheiroConverter.marinheiroDTORes(agendamento.getMarinheiro()));
        dto.setEmbarcacao(EmbarcacaoConverter.embarcacaoConverterDTO(agendamento.getEmbarcacao()));
        return dto;
    }
}
