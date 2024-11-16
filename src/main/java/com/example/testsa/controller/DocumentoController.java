package com.example.testsa.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.testsa.converter.AprovacaoDocumentoConverter;
import com.example.testsa.converter.DocumentoConverter;
import com.example.testsa.dto.req.DocumentoDTOReq;
import com.example.testsa.dto.res.DocumentosDTORes;
import com.example.testsa.entities.Documentos;
import com.example.testsa.service.AprovacaoDocumentoService;
import com.example.testsa.service.DocumentoService;

@RestController
@RequestMapping("/documento")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    
    @Autowired
    private AprovacaoDocumentoService aprovacaoDocumentoService;

     @GetMapping("/") //AJUSTAR
    public ResponseEntity<List<?>> buscarTodasImagens() {
        List<Documentos> listaDocumentos = documentoService.buscarTodasDocumetos();
        List<DocumentosDTORes> lista = listaDocumentos.stream().map(d -> DocumentoConverter.entidadeParaDto(d))
                .toList();
        if (listaDocumentos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok()
                .header("Content-Type", "application/octet-stream") // Ajuste conforme o tipo de imagem
                .body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> buscarImagem(@PathVariable Long id) {
        Documentos doc = documentoService.buscarDocumentoPorId(id);
        System.out.println(doc.getFormato());
        if (doc == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .header("Content-Type", doc.getFormato()) // Ajuste conforme o tipo de imagem
                .body(doc.getDocumento());
    }

    @GetMapping("usuario/{id}")
    public ResponseEntity<List<Documentos>> buscarDocumentoPorIdUsuario(@PathVariable UUID id) {
        List<Documentos> documentos = documentoService.buscarDocumentoPorIdUsuario(id);

        if (documentos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(documentos);
    }

    @PostMapping("/upload/{id}")
    public ResponseEntity<?> uploadImagens(@ModelAttribute DocumentoDTOReq docDTO, @PathVariable UUID id) {

        List<MultipartFile> arquivos = docDTO.getDocumento();
        System.out.println("Número de documentos carregados: "
                + (arquivos != null ? arquivos.size() : "Nenhum documento carregado"));

        if (arquivos == null || arquivos.isEmpty()) {
            return ResponseEntity.badRequest().body("Arquivo vazio.Nenhum documento foi carregado.");
        }

        for (MultipartFile arquivo : arquivos) {
            Documentos entity = DocumentoConverter.dtoParaEntidade(docDTO, id, arquivo);
            System.out.println(id);
            System.out.println(entity.getFormato());
            Documentos docCriado = documentoService.criarDocumento(entity, id);

            aprovacaoDocumentoService.criarPendencia(AprovacaoDocumentoConverter.docEntidadeParaEntidade(docCriado));
        }

        return ResponseEntity.ok("Documento armazenado com sucesso!");
    }
}
