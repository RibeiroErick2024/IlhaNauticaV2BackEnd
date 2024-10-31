package com.example.testsa.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.testsa.dto.req.ImagemEmbarcacaoDTOReq;
import com.example.testsa.entities.ImagemEmbarcacao;
import com.example.testsa.service.ImagemEmbarcacaoService;

@RestController
@RequestMapping("/imagem")
public class ImagemEmbarcacaoController {

    @Autowired
    ImagemEmbarcacaoService imagemEmbarcacaoService;

    @GetMapping("path")
    public String getImagem(@RequestParam String param) {
        return new String();
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImagens(@ModelAttribute ImagemEmbarcacaoDTOReq imagemDTO) {

        
        List<MultipartFile> arquivos = imagemDTO.getImagens();
        System.out.println("Number of uploaded files: " + (arquivos != null ? arquivos.size() : "null"));
    
    if (arquivos == null || arquivos.isEmpty()) {
        return ResponseEntity.badRequest().body("No files uploaded");
    }

        try {
            for (MultipartFile arquivo : arquivos) {
                ImagemEmbarcacao entity = new ImagemEmbarcacao();
                entity.setNome(arquivo.getOriginalFilename());
                entity.setImagem(arquivo.getBytes());
                imagemEmbarcacaoService.createImagem(entity);
            }
        } catch (IOException e) {
            return ResponseEntity.status(500).build(); // Retorna erro em caso de falha no upload
        }

        return ResponseEntity.ok("Imagens enviadas com sucesso!");
    }
}
