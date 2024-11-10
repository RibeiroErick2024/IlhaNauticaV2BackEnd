package com.example.testsa.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testsa.entities.Endereco;
import com.example.testsa.repositories.EnderecoRepository;

import jakarta.transaction.Transactional;

@Service
public class EnderecoService {
    
    @Autowired
    EnderecoRepository enderecoRepository;

    
    @Transactional
    public Endereco cadastrar(Endereco endereco) {

        return enderecoRepository.save(endereco);
    }

    @Transactional
    public List<Endereco> buscarTodos() {
        return enderecoRepository.findAll();
    }

    @Transactional
    public Endereco buscarPorId(UUID id) {

        Optional<Endereco> opt = enderecoRepository.findById(id);
        if (opt.isPresent()) {
            Endereco endereco = opt.get();
            return endereco;
        }

        return null;

    }

     @Transactional
    public Endereco atualizarEndereco(UUID id, Endereco endereco) {
        Optional<Endereco> enderecoExiste = enderecoRepository.findById(id);
        
        if(enderecoExiste.isPresent()){
            Endereco enderecoAtualizado = enderecoExiste.get();
            enderecoAtualizado.setRua(endereco.getRua());
           

        }
    
        return enderecoRepository.saveAndFlush(endereco);
    }
    
    public void deletarendereco(UUID id) {

         enderecoRepository.deleteById(id);
       

        

    }
}
