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
        // criar MarinheiroDTO

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
    public Marinheiro deletarMarinheiro(Marinheiro entity) {

         marinheiroRepository.delete(entity);
       

        return null;

    }
}
