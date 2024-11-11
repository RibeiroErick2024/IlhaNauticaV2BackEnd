package com.example.testsa.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testsa.entities.ImagemEmbarcacao;
import com.example.testsa.repositories.ImagemEmbarcacaoRepository;

import jakarta.transaction.Transactional;

@Service
public class ImagemEmbarcacaoService {
    @Autowired
    ImagemEmbarcacaoRepository imagemEmbarcacaoRepository;

    @Autowired
    EmbarcacaoService embarcacaoService;

    @Transactional
    public ImagemEmbarcacao criarImagem(ImagemEmbarcacao imagemPost) {

        

        ImagemEmbarcacao imagem = new ImagemEmbarcacao();
        imagem.setNome(imagemPost.getNome());
        imagem.setImagem(imagemPost.getImagem());


       
        return imagemEmbarcacaoRepository.save(imagemPost);
    }

    @Transactional
    public List <ImagemEmbarcacao> buscarTodasImagens (){
        return imagemEmbarcacaoRepository.findAll();       
      
    }

    @Transactional
    public ImagemEmbarcacao buscarImagemPorId(Long id) {
        return imagemEmbarcacaoRepository.findById(id).orElse(null);
    }

    @Transactional
    public List<ImagemEmbarcacao> buscarImagemPorIdEmbarcacao(UUID id) {
        return imagemEmbarcacaoRepository.findByEmbarcacaoIdEmbarcacao(id);
    }
    @Transactional //Testar
    public ImagemEmbarcacao atualizarimagemEmbarcacao(Long id, ImagemEmbarcacao imagemEmbarcacao) {
        Optional<ImagemEmbarcacao> imagemExiste = imagemEmbarcacaoRepository.findById(id);
        
        if(imagemExiste.isPresent()){
            ImagemEmbarcacao atualimagemEmbarcacao = imagemExiste.get();
            atualimagemEmbarcacao.setImagem(atualimagemEmbarcacao.getImagem());
            atualimagemEmbarcacao.setNome(imagemEmbarcacao.getNome());
            atualimagemEmbarcacao.setFormato(imagemEmbarcacao.getFormato());
            

        }
    
        return imagemEmbarcacaoRepository.saveAndFlush(imagemEmbarcacao);
    }
   

    @Transactional
    public void deletarImagemPorId(Long id) {
        imagemEmbarcacaoRepository.deleteById(id);
    }

}
