package com.example.testsa.dto.req;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class DocumentoDTOReq {
   
   
    private List<MultipartFile> documento;
 

    public List<MultipartFile> getDocumento() {
        return documento;
    }

    public void setDocumento(List<MultipartFile> documento) {
        this.documento = documento;
    }



}
