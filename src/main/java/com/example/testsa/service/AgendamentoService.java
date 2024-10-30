package com.example.testsa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testsa.entities.Agendamento;
import com.example.testsa.repositories.AgendamentoRepository;

@Service
public class AgendamentoService {
    @Autowired
    AgendamentoRepository agendamentoRepository;


    public void criarAgendamento(){


    }

    public List<Agendamento> ListarAgendamento(){


        return agendamentoRepository.findAll();


    }

    public Optional<Agendamento> getAgendamentoById(Long id){


        return agendamentoRepository.findById(id);


    }
    public void AtualizarAgendamento(){





    }

    public void DeletarAgendamento(){





    }

    
    
}
