package com.example.testsa.dto.req;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ImagemEmbarcacaoDTOReq {
   
    private List<MultipartFile> imagens;

    public List<MultipartFile> getImagens() {
        return imagens;
    }

    public void setImagens(List<MultipartFile> imagens) {
        this.imagens = imagens;
    }
}
