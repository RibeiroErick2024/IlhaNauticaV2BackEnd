package com.example.testsa.service;

import com.example.testsa.converter.AgendamentoConverter;
import com.example.testsa.dto.res.AgendamentosDTORes;
import com.example.testsa.entities.Agendamento;
import com.example.testsa.repositories.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Transactional
    public Agendamento createAgendamento(Agendamento agendamento) {
        // Lógica de criação, se houver alguma regra de negócio, pode ser adicionada aqui
        return agendamentoRepository.save(agendamento);
    }

    @Transactional
    public List<AgendamentosDTORes> buscarTodosAgendamentos() {
        List<Agendamento> todos = agendamentoRepository.findAll();
        return todos.stream()
                .map(AgendamentoConverter::agendamentoConverterDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<AgendamentosDTORes> buscarAgendamentosPorUsuario(UUID idUsuario) {
        List<Agendamento> todos = agendamentoRepository.findByUsuarioId(idUsuario);
        return todos.stream()
                .map(AgendamentoConverter::agendamentoConverterDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<AgendamentosDTORes> buscarAgendamentosPorEmbarcacao(UUID idEmbarcacao) {
        List<Agendamento> todos = agendamentoRepository.findByEmbarcacaoIdEmbarcacao(idEmbarcacao);
        return todos.stream()
                .map(AgendamentoConverter::agendamentoConverterDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<AgendamentosDTORes> buscarAgendamentosPorMarinheiro(UUID idMarinheiro) {
        List<Agendamento> todos = agendamentoRepository.findByMarinheiroIdMarinheiro(idMarinheiro);
        return todos.stream()
                .map(AgendamentoConverter::agendamentoConverterDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public Optional<Agendamento> buscarAgendamentoPorId(UUID id) {
        return agendamentoRepository.findById(id);
    }

    @Transactional
    public Agendamento updateAgendamento(UUID id, Agendamento agendamentoDetails) {
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado com id " + id));

        // Atualizar os campos
        agendamento.setDataInicio(agendamentoDetails.getDataInicio());
        agendamento.setStatus(agendamentoDetails.getStatus());
        agendamento.setDataFinal(agendamentoDetails.getDataFinal());
        agendamento.setUsuario(agendamentoDetails.getUsuario());
        agendamento.setMarinheiro(agendamentoDetails.getMarinheiro());
        agendamento.setEmbarcacao(agendamentoDetails.getEmbarcacao());

        return agendamentoRepository.save(agendamento);
    }

    @Transactional
    public void deleteAgendamento(UUID id) {
        agendamentoRepository.deleteById(id);
    }

    @Transactional
    public void deleteAgendamentoPorUsuario(UUID idUsuario) {
        agendamentoRepository.deleteByUsuarioId(idUsuario);
    }

    @Transactional
    public void deleteAgendamentoPorEmbarcacao(UUID idEmbarcacao) {
        agendamentoRepository.deleteByEmbarcacaoIdEmbarcacao(idEmbarcacao);
    }
}
