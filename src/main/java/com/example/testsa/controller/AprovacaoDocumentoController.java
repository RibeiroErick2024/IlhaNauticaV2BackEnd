package com.example.testsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testsa.entities.AprovacaoDocumento;
import com.example.testsa.service.AprovacaoDocumentoService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/aprovacaodocumento")
public class AprovacaoDocumentoController {

    @Autowired
    AprovacaoDocumentoService aprovacaoDocumentoService;

    @PostMapping("/{id}")
    public AprovacaoDocumento mudarStatus(@RequestBody AprovacaoDocumento entity, @PathVariable Long id) {
        
        return aprovacaoDocumentoService.mudarStatus(entity, id);
     
    }

}
