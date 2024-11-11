package com.example.testsa.dto.res;

import java.time.LocalDate;
import java.util.UUID;

import com.example.testsa.dto.res.Embarcacao.EmbarcacaoSimplesDTORes;
import com.example.testsa.dto.res.Marinheiro.MarinheiroDTORes;
import com.example.testsa.dto.res.Usuario.UsuarioSimplesDTO;

public class AgendamentosDTORes {
    private UUID idAgendamento;
    private LocalDate dataInicio;
    private String status;
    private LocalDate dataFinal;
    private UsuarioSimplesDTO usuario;
    private MarinheiroDTORes marinheiro;
    private EmbarcacaoSimplesDTORes embarcacao;

    public AgendamentosDTORes() {
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    public static class UsuarioDTO {
        private Long idUsuario;
        private String nome;

        public Long getIdUsuario() {
            return idUsuario;
        }

        public void setIdUsuario(Long idUsuario) {
            this.idUsuario = idUsuario;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;

        }
    }

    public MarinheiroDTORes getMarinheiro() {
        return marinheiro;
    }

    public void setMarinheiro(MarinheiroDTORes marinheiro) {
        this.marinheiro = marinheiro;
    }

    public EmbarcacaoSimplesDTORes getEmbarcacao() {
        return embarcacao;
    }

    public void setEmbarcacao(EmbarcacaoSimplesDTORes embarcacao) {
        this.embarcacao = embarcacao;
    }

    public UUID getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(UUID idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public UsuarioSimplesDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioSimplesDTO usuario) {
        this.usuario = usuario;
    }
}
