package com.example.testsa.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testsa.converter.AgendamentoConverter;
import com.example.testsa.dto.res.AgendamentosDTORes;
import com.example.testsa.entities.Agendamento;
import com.example.testsa.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    // Criar Agendamento
    public Agendamento createAgendamento(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    


    //Busca todos os agendamentos
    public List<Agendamento> getAllAgendamentos() {
        return agendamentoRepository.findAll();
    }


    
    public List<AgendamentosDTORes> getAllAgendamentosDTO() {
        return getAllAgendamentos().stream()
                .map(AgendamentoConverter::agendamentoConverterDTO) 
                .collect(Collectors.toList());
    }
    


    //Busca agendamento por id
    public Optional<Agendamento> buscarAgendamentoPorId(Long id) {
        return agendamentoRepository.findById(id);
    }
    
    

   

    // Atualizar Agendamento
    public Agendamento updateAgendamento(Long id, Agendamento agendamentoDetails) {
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado com id " + id));

        agendamento.setDataInicio(agendamentoDetails.getDataInicio());
        agendamento.setStatus(agendamentoDetails.getStatus());
        agendamento.setDataFinal(agendamentoDetails.getDataFinal());
        agendamento.setUsuario(agendamentoDetails.getUsuario());
        agendamento.setMarinheiro(agendamentoDetails.getMarinheiro());
        agendamento.setEmbarcacao(agendamentoDetails.getEmbarcacao());

        return agendamentoRepository.save(agendamento);
    }

    // Deletar Agendamento
    public void deleteAgendamento(Long id) {
        agendamentoRepository.deleteById(id);
    }

    
}
