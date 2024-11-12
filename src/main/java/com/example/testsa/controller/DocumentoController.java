package com.example.testsa.controller;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testsa.dto.req.CadastroDocumentoDTO;
import com.example.testsa.entities.Documento;
import com.example.testsa.service.DocumentoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/documento")
public class DocumentoController {
    
    @Autowired
    private DocumentoService documentoService;

    @PostMapping("/criar")
    public ResponseEntity<String> criarDocumento(@RequestBody CadastroDocumentoDTO dto) {
        try {
            Documento documentos = new Documento();

            // Remove espaços em branco da string Base64 antes de decodificá-la
            byte[] base64String = dto.getDocumento();
            byte[] documentoBytes = Base64.getDecoder().decode(base64String);
            documentos.setDocumento(documentoBytes);
            documentos.setStatus(dto.getStatus());
            documentos.setNome(dto.getNome());

            // Salvar o documento
            documentoService.createDocumento(documentos);
            
            return ResponseEntity.status(HttpStatus.CREATED).body("Documento criado com sucesso!");
        } catch (IllegalArgumentException e) {
            // Tratamento de erro para string Base64 inválida
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                 .body("Erro ao decodificar o documento: " + e.getMessage());
        } catch (Exception e) {
            // Tratamento de erro genérico
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Erro ao criar o documento: " + e.getMessage());
        }
    }
}
