package com.example.testsa.converter;

import com.example.testsa.dto.req.AgendamentoDTOReq;
import com.example.testsa.dto.res.AgendamentosDTORes;
import com.example.testsa.entities.Agendamento;
import com.example.testsa.entities.Embarcacao;
import com.example.testsa.entities.Marinheiro;
import com.example.testsa.entities.Usuario;

public class AgendamentoConverter {
    public static AgendamentosDTORes agendamentoConverterDTO(Agendamento agendamento) {
        AgendamentosDTORes dto = new AgendamentosDTORes();
        dto.setIdAgendamento(agendamento.getIdAgendamento());
        dto.setDataInicio(agendamento.getDataInicio());
        dto.setStatus(agendamento.getStatus());
        dto.setDataFinal(agendamento.getDataFinal());
        dto.setUsuario(agendamento.getUsuario() != null ? UsuarioConverter.usuarioConverterSimples(agendamento.getUsuario()) : null);
        dto.setMarinheiro(agendamento.getMarinheiro() != null ? MarinheiroConverter.entidadeParaMarinheiroDTO(agendamento.getMarinheiro()) : null);
        dto.setEmbarcacao(agendamento.getEmbarcacao() != null ? EmbarcacaoConverter.embarcacaoConverterDTOSimples(agendamento.getEmbarcacao()): null);
        return dto;
    }

    public Agendamento agendamentoConverterEntdade(AgendamentoDTOReq dto) {
        Agendamento agendamento = new Agendamento();
        agendamento.setIdAgendamento(dto.getIdAgendamento());
        agendamento.setDataInicio(dto.getDataInicio());
        agendamento.setStatus(dto.getStatus());
        agendamento.setDataFinal(dto.getDataFinal());

        Usuario usuario = new Usuario();
        usuario.setId(dto.getIdUsuario() != null ? dto.getIdUsuario() : null);
    
        Marinheiro marinheiro = new Marinheiro();
        marinheiro.setIdMarinheiro(dto.getIdMarinheiro() != null ? dto.getIdMarinheiro() : null);
        Embarcacao embarcacao = new Embarcacao();
        embarcacao.setIdEmbarcacao(dto.getIdEmbarcacao() != null ? dto.getIdEmbarcacao() : null);

        agendamento.setUsuario(usuario);
        agendamento.setMarinheiro(marinheiro);
        agendamento.setEmbarcacao(embarcacao);

        return agendamento;
    }
}
