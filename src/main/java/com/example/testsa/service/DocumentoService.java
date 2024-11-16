package com.example.testsa.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testsa.entities.Documentos;
import com.example.testsa.repositories.DocumentoRepository;

import jakarta.transaction.Transactional;

@Service
public class DocumentoService {

    @Autowired
    DocumentoRepository documentoRepository;



    public List<Documentos> getAllDocumentos() {
        return documentoRepository.findAll();
    }

    @Transactional
    public Documentos criarDocumento(Documentos documento, UUID id) {

        Documentos doc = new Documentos();
        doc.setNome(documento.getNome());
        doc.setDocumento(documento.getDocumento());
        doc.setFormato(documento.getFormato());
        doc.setStatus(documento.getStatus());
        doc.setUsuario(documento.getUsuario());

        return documentoRepository.save(doc);
    }

    @Transactional
    public List<Documentos> buscarTodasDocumetos() {
        return documentoRepository.findAll();

    }

    @Transactional
    public Documentos buscarDocumentoPorId(Long id) {
        return documentoRepository.findById(id).orElse(null);
    }

    @Transactional
    public List<Documentos> buscarDocumentoPorIdUsuario(UUID id) {
        return documentoRepository.findByUsuarioId(id);
    }

    @Transactional // Testar
    public Documentos trocarDocumento(Long id, Documentos documento) {
        Optional<Documentos> documentoExiste = documentoRepository.findById(id);

        if (documentoExiste.isPresent()) {
            Documentos atualdocumento = documentoExiste.get();
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
