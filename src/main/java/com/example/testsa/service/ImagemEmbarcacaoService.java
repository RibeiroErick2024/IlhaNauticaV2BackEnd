package com.example.testsa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testsa.entities.ImagemEmbarcacao;
import com.example.testsa.repositories.ImagemEmbarcacaoRepository;

import jakarta.transaction.Transactional;

@Service
public class ImagemEmbarcacaoService {
    @Autowired
    ImagemEmbarcacaoRepository imagemEmbarcacaoRepository;

    @Transactional
    public ImagemEmbarcacao criarImagem(ImagemEmbarcacao imagemPost) {
        ImagemEmbarcacao imagem = new ImagemEmbarcacao();
        imagem.setNome(imagemPost.getNome());
        imagem.setImagem(imagemPost.getImagem());
       
        return imagemEmbarcacaoRepository.save(imagemPost);
    }

    public List <ImagemEmbarcacao> buscarTodasImagens (){
        return imagemEmbarcacaoRepository.findAll();       
      
    }

    public ImagemEmbarcacao buscarImagemPorId(Long id) {
        return imagemEmbarcacaoRepository.findById(id).orElse(null);
    }

}
