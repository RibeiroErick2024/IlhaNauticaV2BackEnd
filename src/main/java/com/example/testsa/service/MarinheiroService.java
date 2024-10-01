package com.example.testsa.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testsa.entities.Marinheiro;
import com.example.testsa.repositories.MarinheiroRepository;



@Service
public class MarinheiroService {
    
    @Autowired
    MarinheiroRepository marinheiroRepository;


    // Marinheiro recebido do post. Que veio do Controller
    public Marinheiro createUsuario(Marinheiro marinheiroPost) {

        return marinheiroRepository.save(marinheiroPost);
    }

    public List <Marinheiro> getAllMarinheiro (){
        return marinheiroRepository.findAll();
        // criar MarinheiroDTO
        
      
    }
}
