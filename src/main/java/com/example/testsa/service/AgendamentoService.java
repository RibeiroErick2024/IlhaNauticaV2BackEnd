package com.example.testsa.service;

import com.example.testsa.converter.AgendamentoConverter;
import com.example.testsa.dto.req.AgendamentoDTOReq;
import com.example.testsa.dto.res.AgendamentosDTORes;
import com.example.testsa.entities.Agendamento;
import com.example.testsa.entities.Embarcacao;
import com.example.testsa.entities.Usuario;
import com.example.testsa.repositories.AgendamentoRepository;
import com.example.testsa.repositories.EmbarcacaoRepository;
import com.example.testsa.repositories.UsuarioRepository;

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
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmbarcacaoRepository embarcacaoRepository;

    @Transactional
    public AgendamentosDTORes createAgendamento(AgendamentoDTOReq dto) {
        
        Agendamento agendamento = AgendamentoConverter.agendamentoConverterEntidade(dto);

        if (agendamento.getUsuario() == null || agendamento.getUsuario().getId() == null) {
            throw new IllegalArgumentException("Por favor, forneça um Usuário ID para o agendamento.");
        }

        Usuario usuario = usuarioRepository.findById(agendamento.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        if (agendamento.getEmbarcacao() == null || agendamento.getEmbarcacao().getIdEmbarcacao() == null) {
            throw new IllegalArgumentException("Por favor, forneça um embarcacao ID para o agendamento.");
        }

        Embarcacao embarcacao = embarcacaoRepository.findById(agendamento.getEmbarcacao().getIdEmbarcacao())
                .orElseThrow(() -> new RuntimeException("Embarcacao não encontrada."));

        agendamento.setUsuario(usuario);
        agendamento.setEmbarcacao(embarcacao);

        Agendamento agendamentoCriado =  agendamentoRepository.save(agendamento);
        return  AgendamentoConverter.agendamentoConverterDTO(agendamentoCriado);
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
    public AgendamentosDTORes atualizarAgendamento(UUID id, AgendamentoDTOReq dto) {
     
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado com id " + id));

    
        agendamento.setDataInicio(dto.getDataInicio());
        agendamento.setStatus(dto.getStatus());
        agendamento.setDataFinal(dto.getDataFinal());


        agendamentoRepository.save(agendamento);
        return AgendamentoConverter.agendamentoConverterDTO(agendamento);
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
    // @Transactional
// public Agendamento criarAgendamento(Agendamento agendamento) {
//     // Verificar se existe algum agendamento no mesmo período
//     List<Agendamento> agendamentosExistentes = agendamentoRepository.findAll();

//     for (Agendamento existente : agendamentosExistentes) {
//         // Verificar se as datas se sobrepõem
//         if (existeSobreposicao(agendamento, existente)) {
//             throw new RuntimeException("Já existe um agendamento para o mesmo período.");
//         }
//     }

//     // Caso não haja sobreposição, salva o novo agendamento
//     return agendamentoRepository.save(agendamento);
// }

// private boolean existeSobreposicao(Agendamento novoAgendamento, Agendamento agendamentoExistente) {
//     // Verifica se as datas de início e fim do novo agendamento coincidem com o agendamento existente
//     boolean sobrepoeDataInicio = novoAgendamento.getDataInicio().isBefore(agendamentoExistente.getDataFinal()) &&
//             !novoAgendamento.getDataFinal().isBefore(agendamentoExistente.getDataInicio());

//     boolean sobrepoeDataFinal = novoAgendamento.getDataFinal().isAfter(agendamentoExistente.getDataInicio()) &&
//             !novoAgendamento.getDataInicio().isAfter(agendamentoExistente.getDataFinal());

//     return sobrepoeDataInicio || sobrepoeDataFinal;
// }
}


