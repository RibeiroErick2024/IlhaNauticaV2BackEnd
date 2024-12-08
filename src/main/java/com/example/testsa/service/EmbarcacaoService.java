package com.example.testsa.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testsa.converter.EmbarcacaoConverter;
import com.example.testsa.dto.req.EmbarcacaoDTOReq;
import com.example.testsa.dto.res.Embarcacao.EmbarcacaoDTORes;
import com.example.testsa.entities.Embarcacao;
import com.example.testsa.entities.Usuario;
import com.example.testsa.repositories.EmbarcacaoRepository;
import com.example.testsa.repositories.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class EmbarcacaoService {

    @Autowired
    EmbarcacaoRepository embarcacaoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Transactional
    public List<Embarcacao> buscarTodasEmbarcacoes() {
        return embarcacaoRepository.findAll();
    }

    @Transactional
    public EmbarcacaoDTORes criarEmbarcacao(EmbarcacaoDTOReq dto) {
        Embarcacao embarcacao = EmbarcacaoConverter.dtoConverterEntidade(dto);

        Usuario usuario = usuarioRepository.findById(embarcacao.getUsuario().getId())
            .orElseThrow(() -> new EntityNotFoundException("Usuário com ID " + embarcacao.getUsuario().getId() + " não encontrado."));
     
            usuario.setCategoriaUsuario("Locador");
        Usuario u = usuarioRepository.saveAndFlush(usuario);
        System.out.println(u.getCategoriaUsuario());
        embarcacao.setUsuario(u);
        

        return EmbarcacaoConverter.embarcacaoConverterDTO(embarcacaoRepository.save(embarcacao));

    }

    public Embarcacao buscarEmbarcacaoPorId(UUID id) {
       

        return embarcacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Embarcação com ID " + id + " não encontrada."));
    }

    @Transactional
    public EmbarcacaoDTORes atualizarEmbarcacao(UUID id_embarcacao, EmbarcacaoDTOReq embarcacao) {
        Embarcacao entidade = embarcacaoRepository.findById(id_embarcacao)
                .orElseThrow(() -> new EntityNotFoundException("Embarcação com ID " + id_embarcacao + " não encontrada."));

        entidade.setNome(embarcacao.getNome());
        entidade.setAnoFabricacao(embarcacao.getAnoFabricacao());
        entidade.setTamanho(embarcacao.getTamanho());
        entidade.setCapacidade(embarcacao.getCapacidade());
        entidade.setCategoria(embarcacao.getCategoria());
        entidade.setEnderecoEmbarque(embarcacao.getEnderecoEmbarque());
        entidade.setDisponibilidade(embarcacao.getDisponibilidade());
        entidade.setPet(embarcacao.getPet());
        entidade.setQuantidadeBanheiro(embarcacao.getQuantidadeBanheiro());
        entidade.setQuantidadeCabines(embarcacao.getQuantidadeCabines());
        entidade.setInscricao(embarcacao.getInscricao());
        entidade.setBandeira(embarcacao.getBandeira());

        Embarcacao criada = embarcacaoRepository.saveAndFlush(entidade);
        return EmbarcacaoConverter.embarcacaoConverterDTO(criada);

    }

    public void deleteEmbarcacao(UUID id_embarcacao) {
        embarcacaoRepository.findById(id_embarcacao).orElseThrow(() -> new RuntimeException("Embarcação com ID " + id_embarcacao + " não encontrada."));
            
        embarcacaoRepository.deleteById(id_embarcacao);
        
    
    }
}
