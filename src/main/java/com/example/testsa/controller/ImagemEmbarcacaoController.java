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

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImagens(@ModelAttribute ImagemEmbarcacaoDTOReq imagemDTO) {

        List<MultipartFile> arquivos = imagemDTO.getImagens();
        System.out.println("Número de imagem carregadas: " + (arquivos != null ? arquivos.size() : "null"));

        if (arquivos == null || arquivos.isEmpty()) {
            return ResponseEntity.badRequest().body("Nenhuma imagem foi carregada.");
        }

        try {
            for (MultipartFile arquivo : arquivos) {
                ImagemEmbarcacao entity = new ImagemEmbarcacao();
                entity.setNome(arquivo.getOriginalFilename());
                entity.setImagem(arquivo.getBytes());
                entity.setFormato(arquivo.getContentType());
                imagemEmbarcacaoService.criarImagem(entity);
            }
        } catch (IOException e) {
            return ResponseEntity.status(500).build();
        }

        return ResponseEntity.ok("Imagens enviadas com sucesso!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getImagem(@PathVariable Long id) {
        ImagemEmbarcacao imagem = imagemEmbarcacaoService.buscarImagemPorId(id);

        if (imagem == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .header("Content-Type", imagem.getFormato()) // Ajuste conforme o tipo de imagem
                .body(imagem.getImagem());
    }

    @GetMapping("/")
    public ResponseEntity<List<ImagemEmbarcacao>> getAllImagens() {
        List<ImagemEmbarcacao> imagens = imagemEmbarcacaoService.buscarTodasImagens();

        if (imagens.isEmpty()) {
            return ResponseEntity.noContent().build(); 
        }

        return ResponseEntity.ok(imagens);
    }
}
