package com.example.testsa.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    public Documento createDocumento(Documento documento) {
        return documentoRepository.save(documento);

    }

    @Transactional
    public Documento criarDocumento(Documento documento, UUID id) {

        Documento doc = new Documento();
        doc.setNome(documento.getNome());
        doc.setDocumento(documento.getDocumento());
        doc.setFormato(documento.getFormato());

        return documentoRepository.save(doc);
    }

    @Transactional
    public List<Documento> buscarTodasDocumetos() {
        return documentoRepository.findAll();

    }

    @Transactional
    public Documento buscarDocumentoPorId(Long id) {
        return documentoRepository.findById(id).orElse(null);
    }

    @Transactional
    public List<Documento> buscarDocumentoPorIdUsuario(UUID id) {
        return documentoRepository.findByUsuarioId(id);
    }

    @Transactional // Testar
    public Documento trocarDocumento(Long id, Documento documento) {
        Optional<Documento> documentoExiste = documentoRepository.findById(id);

        if (documentoExiste.isPresent()) {
            Documento atualdocumento = documentoExiste.get();
            atualdocumento.setDocumento(atualdocumento.getDocumento());
            atualdocumento.setNome(documento.getNome());
            atualdocumento.setFormato(documento.getFormato());

        }

        return documentoRepository.saveAndFlush(documento);
    }

    @Transactional
    public void deletarDocumentoPorId(Long id) {
        documentoRepository.deleteById(id);
    }

}
