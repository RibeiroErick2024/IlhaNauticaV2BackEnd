package com.example.testsa.dto.req;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ImagemEmbarcacaoDTOReq {
   
    private List<MultipartFile> imagens;

    private EmbarcacaoDTOReq embarcacao;

    
    public List<MultipartFile> getImagens() {
        return imagens;
    }

    public void setImagens(List<MultipartFile> imagens) {
        this.imagens = imagens;
    }

    public EmbarcacaoDTOReq getEmbarcacao() {
        return embarcacao;
    }

    public void setEmbarcacao(EmbarcacaoDTOReq embarcacao) {
        this.embarcacao = embarcacao;
    }
}
