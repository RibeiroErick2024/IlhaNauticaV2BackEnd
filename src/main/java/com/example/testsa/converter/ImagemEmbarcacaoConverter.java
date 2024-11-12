package com.example.testsa.converter;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.example.testsa.dto.req.ImagemEmbarcacaoDTOReq;
import com.example.testsa.dto.res.ImagemEmbarcacaoDTORes;
import com.example.testsa.entities.ImagemEmbarcacao;

public interface ImagemEmbarcacaoConverter {

    public static ImagemEmbarcacao dtoParaEntidade(ImagemEmbarcacaoDTOReq dto ,MultipartFile arquivo) throws IOException {
        ImagemEmbarcacao entity = new ImagemEmbarcacao();
        entity.setNome(arquivo.getOriginalFilename());
        entity.setImagem(arquivo.getBytes());
        entity.setFormato(arquivo.getContentType());
        // entity.setEmbarcacao(EmbarcacaoConverter.dtoConverterEntidade(dto.getEmbarcacao()));
        return entity;
    }
    public static ImagemEmbarcacaoDTORes entidadeParaDto(ImagemEmbarcacao entidade) {
        ImagemEmbarcacaoDTORes dto = new ImagemEmbarcacaoDTORes();
        dto.setNome(entidade.getNome());
        dto.setImagem(entidade.getImagem());
        dto.setFormato(entidade.getFormato());
        return dto;
    }
}