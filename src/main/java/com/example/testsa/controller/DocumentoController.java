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

import com.example.testsa.converter.DocumentoConverter;
import com.example.testsa.dto.req.DocumentoDTOReq;
import com.example.testsa.dto.res.DocumentosDTORes;
import com.example.testsa.entities.Documento;
import com.example.testsa.service.DocumentoService;

@RestController
@RequestMapping("/documento")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    // @PostMapping("/criar")
    // public ResponseEntity<String> criarDocumento(@RequestBody
    // CadastroDocumentoDTO dto) {
    // try {
    // Documento documentos = new Documento();

    // // Remove espaços em branco da string Base64 antes de decodificá-la
    // byte[] base64String = dto.getDocumento();
    // byte[] documentoBytes = Base64.getDecoder().decode(base64String);
    // documentos.setDocumento(documentoBytes);
    // documentos.setStatus(dto.getStatus());
    // documentos.setNome(dto.getNome());

    // // Salvar o documento
    // documentoService.createDocumento(documentos);

    // return ResponseEntity.status(HttpStatus.CREATED).body("Documento criado com
    // sucesso!");
    // } catch (IllegalArgumentException e) {
    // // Tratamento de erro para string Base64 inválida
    // return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    // .body("Erro ao decodificar o documento: " + e.getMessage());
    // } catch (Exception e) {
    // // Tratamento de erro genérico
    // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
    // .body("Erro ao criar o documento: " + e.getMessage());
    // }
    // }

    @GetMapping("/") //AJUSTAR
    public ResponseEntity<List<?>> buscarTodasImagens() {
        List<Documento> listaDocumentos = documentoService.buscarTodasDocumetos();
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
        Documento doc = documentoService.buscarDocumentoPorId(id);
        System.out.println(doc.getFormato());
        if (doc == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .header("Content-Type", doc.getFormato()) // Ajuste conforme o tipo de imagem
                .body(doc.getDocumento());
    }

    @GetMapping("usuario/{id}")
    public ResponseEntity<List<Documento>> buscarDocumentoPorIdUsuario(@PathVariable UUID id) {
        List<Documento> documentos = documentoService.buscarDocumentoPorIdUsuario(id);

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
            Documento entity = DocumentoConverter.dtoParaEntidade(docDTO, arquivo);
            System.out.println(id);
            System.out.println(entity.getFormato());
            documentoService.criarDocumento(entity, id);
        }

        return ResponseEntity.ok("Imagens enviadas com sucesso!");
    }
}
