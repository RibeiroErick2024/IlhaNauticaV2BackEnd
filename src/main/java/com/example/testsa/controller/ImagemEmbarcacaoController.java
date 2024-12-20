package com.example.testsa.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.testsa.converter.ImagemEmbarcacaoConverter;
import com.example.testsa.dto.req.ImagemEmbarcacaoDTOReq;
import com.example.testsa.entities.ImagemEmbarcacao;
import com.example.testsa.service.ImagemEmbarcacaoService;

@RestController
@RequestMapping("/imagem")
public class ImagemEmbarcacaoController {

    @Autowired
    ImagemEmbarcacaoService imagemEmbarcacaoService;

    @GetMapping("/")
    public ResponseEntity<List<ImagemEmbarcacao>> buscarTodasImagens() {
        List<ImagemEmbarcacao> imagens = imagemEmbarcacaoService.buscarTodasImagens();

        if (imagens.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(imagens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> buscarImagem(@PathVariable Long id) {
        ImagemEmbarcacao imagem = imagemEmbarcacaoService.buscarImagemPorId(id);
        System.out.println(imagem.getFormato());
    
        return ResponseEntity.ok()
                .header("Content-Type", imagem.getFormato()) 
                .body(imagem.getImagem());
    }

    @GetMapping("embarcacao/{id}")
    public ResponseEntity<List<ImagemEmbarcacao>> buscarImagemPorEmbarcacao(@PathVariable UUID id) {
        List<ImagemEmbarcacao> imagens = imagemEmbarcacaoService.buscarImagemPorIdEmbarcacao(id);

        if (imagens.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(imagens);
    }

    @PostMapping("/upload/{idEmbarcacao}")
    public ResponseEntity<?> uploadImagens(@ModelAttribute ImagemEmbarcacaoDTOReq imagemDTO, @PathVariable UUID idEmbarcacao) {

        List<MultipartFile> arquivos = imagemDTO.getImagens();
        System.out.println("Número de imagem carregadas: " + (arquivos != null ? arquivos.size() : "null"));

        if (arquivos == null || arquivos.isEmpty()) {
            return ResponseEntity.badRequest().body("Nenhuma imagem foi carregada.");
        }

        try {
            for (MultipartFile arquivo : arquivos) {
                ImagemEmbarcacao entity = ImagemEmbarcacaoConverter.dtoParaEntidade(imagemDTO, arquivo);
                System.out.println(idEmbarcacao);
                System.out.println(entity.getFormato());
                imagemEmbarcacaoService.criarImagem(entity, idEmbarcacao);
            }
        } catch (IOException e) {
            return ResponseEntity.status(500).build();
        }

        return ResponseEntity.ok("Imagens enviadas com sucesso!");
    }

}
