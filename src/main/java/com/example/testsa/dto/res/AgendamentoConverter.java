package com.example.testsa.dto.res;

import com.example.testsa.entities.Agendamento;

public class AgendamentoConverter {
     public static AgendamentosDTORes agendamentoConverterDTO(Agendamento agendamento) {
        AgendamentosDTORes dto = new AgendamentosDTORes();
        dto.setIdAgendamento(agendamento.getIdAgendamento());
        dto.setDataInicio(agendamento.getDataInicio());
        dto.setStatus(agendamento.getStatus());
        dto.setDataFinal(agendamento.getDataFinal());
        

   
        return dto;
    }
}
