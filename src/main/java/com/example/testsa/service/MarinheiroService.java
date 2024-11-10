package com.example.testsa.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testsa.entities.Marinheiro;
import com.example.testsa.repositories.MarinheiroRepository;

import jakarta.transaction.Transactional;

@Service
public class MarinheiroService {

    @Autowired
    MarinheiroRepository marinheiroRepository;

    @Transactional
    public Marinheiro cadastrar(Marinheiro marinheiroPost) {

        return marinheiroRepository.save(marinheiroPost);
    }

    @Transactional
    public List<Marinheiro> buscarTodos() {
        return marinheiroRepository.findAll();
    }

    @Transactional
    public Marinheiro buscarPorId(UUID id) {

        Optional<Marinheiro> opt = marinheiroRepository.findById(id);
        if (opt.isPresent()) {
            Marinheiro marinheiro = opt.get();
            return marinheiro;
        }

        return null;

    }
     @Transactional
    public Marinheiro atualizarMarinheiro(UUID id, Marinheiro marinheiro) {
        Optional<Marinheiro> marinheiroExiste = marinheiroRepository.findById(id);
        
        if(marinheiroExiste.isPresent()){
            Marinheiro atualMarinheiro = marinheiroExiste.get();
            atualMarinheiro.setDisponibilidade(marinheiro.getDisponibilidade());
            atualMarinheiro.setNome(marinheiro.getNome());
            atualMarinheiro.setCategoria(marinheiro.getCategoria());
            atualMarinheiro.setAnosExperiencia(marinheiro.getAnosExperiencia());
            atualMarinheiro.setDisponibilidade(marinheiro.getDisponibilidade());
            atualMarinheiro.setRegistroMaritimo(marinheiro.getRegistroMaritimo());

        }
    
        return marinheiroRepository.saveAndFlush(marinheiro);
    }
    
    public void deletarMarinheiro(UUID id) {

         marinheiroRepository.deleteById(id);
       

        

    }
}
