package com.example.testsa.converter;

import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.example.testsa.dto.req.DocumentoDTOReq;
import com.example.testsa.dto.res.DocumentosDTORes;
import com.example.testsa.entities.Documentos;
import com.example.testsa.entities.Usuario;

public class DocumentoConverter {
    
public static Documentos dtoParaEntidade(DocumentoDTOReq dto, UUID id, MultipartFile arquivo) {
    Documentos documentos = new Documentos();
    documentos.setStatus("PENDENTE");
    documentos.setNome(arquivo.getOriginalFilename());
    documentos.setFormato(arquivo.getContentType());
    Usuario usuarioId = new Usuario();
    usuarioId.setId(id); 
    documentos.setUsuario(usuarioId);
   
    try {
        documentos.setDocumento(arquivo.getBytes());
    } catch (IOException e) {
        System.out.println(e);
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    documentos.setFormato(arquivo.getContentType());

    return documentos;
}


    public static DocumentosDTORes entidadeParaDto(Documentos entidade) {
        DocumentosDTORes dto = new DocumentosDTORes();
        dto.setNome(entidade.getNome());
        dto.setDocumento(entidade.getDocumento());
        dto.setFormato(entidade.getFormato());
        return dto;
    }

}
