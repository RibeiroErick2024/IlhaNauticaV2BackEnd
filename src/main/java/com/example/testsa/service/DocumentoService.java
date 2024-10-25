package com.example.testsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testsa.entities.Documento;
import com.example.testsa.repositories.DocumentoRepository;

import jakarta.transaction.Transactional;

@Service
public class DocumentoService {
    
    @Autowired
    DocumentoRepository documentoRepository;

      public List<Documento> getAllDocumentos() {
        return documentoRepository.findAll();
    }

    @Transactional
    public Documento createDocumento(Documento documento){
      return documentoRepository.save(documento);
    }

}
