package com.example.testsa.converter;

import java.util.Base64;

import com.example.testsa.dto.req.CadastroDocumentoDTO;
import com.example.testsa.entities.Documento;
import com.example.testsa.entities.Usuario;

public class DocumentoConverter {
    
public Documento dtoParaDocumentos(CadastroDocumentoDTO dto, Usuario usuario) {
    Documento documentos = new Documento();
    documentos.setStatus(dto.getStatus());
    documentos.setNome(dto.getNome());
    documentos.setUsuario(usuario);
    
    // Decodifica a string Base64 para byte[]
    byte[] documentoBytes = Base64.getDecoder().decode(dto.getDocumento());
    documentos.setDocumento(documentoBytes);

    return documentos;
}

}
