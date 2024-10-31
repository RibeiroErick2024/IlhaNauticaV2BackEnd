package com.example.testsa.dto.res;

import java.time.LocalDate;

public class AgendamentosDTORes {
    private Long idAgendamento;
    private LocalDate dataInicio;
    private String status;
    private LocalDate dataFinal;
    private UsuarioDTO usuario;
    private MarinheiroDTO marinheiro;
    private EmbarcacaoDTO embarcacao;

 
    public AgendamentosDTORes() {
    }

    
    public Long getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(Long idAgendamento) {
        this.idAgendamento = idAgendamento;
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

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public MarinheiroDTO getMarinheiro() {
        return marinheiro;
    }

    public void setMarinheiro(MarinheiroDTO marinheiro) {
        this.marinheiro = marinheiro;
    }

    public EmbarcacaoDTO getEmbarcacao() {
        return embarcacao;
    }

    public void setEmbarcacao(EmbarcacaoDTO embarcacao) {
        this.embarcacao = embarcacao;
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

   
    public static class MarinheiroDTO {
        private Long idMarinheiro;
        private String nome;
        

        
        public Long getIdMarinheiro() {
            return idMarinheiro;
        }

        public void setIdMarinheiro(Long idMarinheiro) {
            this.idMarinheiro = idMarinheiro;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
    }

    
    public static class EmbarcacaoDTO {
        private Long idEmbarcacao;
        private String nome;
        

        
        public Long getIdEmbarcacao() {
            return idEmbarcacao;
        }

        public void setIdEmbarcacao(Long idEmbarcacao) {
            this.idEmbarcacao = idEmbarcacao;
        }
       

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }
    }
}
