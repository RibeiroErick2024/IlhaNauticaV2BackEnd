package com.example.testsa.converter;

import org.springframework.stereotype.Component;

import com.example.testsa.dto.req.AvaliacaoDTOReq;
import com.example.testsa.dto.res.AvaliacaoDTORes;
import com.example.testsa.entities.Avaliacao;
import com.example.testsa.entities.Usuario;

@Component
public interface AvaliacaoConverter {


    public static AvaliacaoDTORes entidadeConverterDTO(Avaliacao avaliacao) {
        AvaliacaoDTORes dto = new AvaliacaoDTORes();
        dto.setIdAvaliacao(avaliacao.getIdAvaliacao());
        dto.setComentario(avaliacao.getComentario());
        dto.setNotaMarinheiro(avaliacao.getNotaMarinheiro());
        dto.setNotaEmbarcacao(avaliacao.getNotaEmbarcacao());
        dto.setNotaAgendamento(avaliacao.getNotaAgendamento());
        dto.setUsuario(avaliacao.getUsuario() != null ? UsuarioConverter.usuarioConverterSimples(avaliacao.getUsuario()) : null);
        // dto.setIdMarinheiro(avaliacao.getMarinheiro() != null ? avaliacao.getMarinheiro().getIdMarinheiro() : null);
        dto.setIdEmbarcacao(avaliacao.getEmbarcacao() != null ? avaliacao.getEmbarcacao().getIdEmbarcacao() : null);
        // dto.setIdAgendamento(avaliacao.getAgendamento() != null ? avaliacao.getAgendamento().getIdAgendamento() : null);
        return dto;
    }

    public static Avaliacao avaliacaoConverterEntidade(AvaliacaoDTOReq dto) {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setComentario(dto.getComentario());
        avaliacao.setNotaMarinheiro(dto.getNotaMarinheiro());
        avaliacao.setNotaEmbarcacao(dto.getNotaEmbarcacao());
        avaliacao.setNotaAgendamento(dto.getNotaAgendamento());
     
        Usuario usuario = new Usuario();
        usuario.setId(dto.getIdUsuario());
    
        // Marinheiro marinheiro = new Marinheiro();
        // marinheiro.setIdMarinheiro(dto.getIdMarinheiro() != null ? dto.getIdMarinheiro() : null);
        // Embarcacao embarcacao = new Embarcacao();
        // embarcacao.setIdEmbarcacao(dto.getIdEmbarcacao() != null ? dto.getIdEmbarcacao() : null);

        avaliacao.setUsuario(usuario);
        // avaliacao.setMarinheiro(marinheiro);
        // avaliacao.setEmbarcacao(embarcacao);

        //avaliacao.setMarinheiro(fetchMarinheiroById(dto.getIdMarinheiro()));
        //avaliacao.setEmbarcacao(fetchEmbarcacaoById(dto.getIdEmbarcacao()));
        //avaliacao.setAgendamento(fetchAgendamentoById(dto.getIdAgendamento()));
        return avaliacao;
    }
}