package com.example.testsa.converter;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.example.testsa.dto.req.DocumentoDTOReq;
import com.example.testsa.dto.res.DocumentosDTORes;
import com.example.testsa.entities.Documento;

public class DocumentoConverter {
    
public static Documento dtoParaEntidade(DocumentoDTOReq dto, MultipartFile arquivo) {
    Documento documentos = new Documento();
    documentos.setStatus("Pendente");
    documentos.setNome(arquivo.getOriginalFilename());
    documentos.setFormato(arquivo.getContentType());
    // documentos.setUsuario(usuario);
   
    try {
        documentos.setDocumento(arquivo.getBytes());
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    documentos.setFormato(arquivo.getContentType());

    return documentos;
}


    public static DocumentosDTORes entidadeParaDto(Documento entidade) {
        DocumentosDTORes dto = new DocumentosDTORes();
        dto.setNome(entidade.getNome());
        dto.setDocumento(entidade.getDocumento());
        dto.setFormato(entidade.getFormato());
        return dto;
    }

}
