package com.example.testsa.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.testsa.entities.Embarcacao;
import com.example.testsa.entities.Usuario;
import com.example.testsa.repositories.EmbarcacaoRepository;
import com.example.testsa.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class EmbarcacaoService {

    @Autowired
    EmbarcacaoRepository embarcacaoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Transactional
    public List<Embarcacao> getAllEmbarcacaos() {
        return embarcacaoRepository.findAll();
    }

    @Transactional
    public Embarcacao creatEmbarcacao(Embarcacao embarcacao) {

        Usuario usuario = usuarioRepository.findById(embarcacao.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        embarcacao.setUsuario(usuario);

        return embarcacaoRepository.save(embarcacao);
    }

    public Embarcacao getEmbarcacaoById(UUID id_embarcacao) {
        return embarcacaoRepository.findById(id_embarcacao)
                .orElseThrow(() -> new RuntimeException("Embarcação com ID " + id_embarcacao + " não encontrada."));
    }

    @Transactional
    public Embarcacao updateEmbarcacao(UUID id_embarcacao, Embarcacao updateEmbarcacao) {
        Embarcacao embarcacaoToUpdate = embarcacaoRepository.findById(id_embarcacao)
                .orElseThrow(() -> new RuntimeException("Embarcação com ID " + id_embarcacao + " não encontrada."));

        embarcacaoToUpdate.setNome(updateEmbarcacao.getNome());
        embarcacaoToUpdate.setAnoFabricacao(updateEmbarcacao.getAnoFabricacao());
        embarcacaoToUpdate.setTamanho(updateEmbarcacao.getTamanho());
        embarcacaoToUpdate.setCapacidade(updateEmbarcacao.getCapacidade());
        embarcacaoToUpdate.setCategoria(updateEmbarcacao.getCategoria());
        embarcacaoToUpdate.setEnderecoEmbarque(updateEmbarcacao.getEnderecoEmbarque());
        embarcacaoToUpdate.setDisponibilidade(updateEmbarcacao.getDisponibilidade());
        embarcacaoToUpdate.setImagem(updateEmbarcacao.getImagem());
        embarcacaoToUpdate.setPet(updateEmbarcacao.getPet());
        embarcacaoToUpdate.setQuantidadeBanheiro(updateEmbarcacao.getQuantidadeBanheiro());
        embarcacaoToUpdate.setQuantidadeCabines(updateEmbarcacao.getQuantidadeCabines());
        embarcacaoToUpdate.setInscricao(updateEmbarcacao.getInscricao());
        embarcacaoToUpdate.setBandeira(updateEmbarcacao.getBandeira());
        embarcacaoToUpdate.setUsuario(updateEmbarcacao.getUsuario());

        return embarcacaoRepository.saveAndFlush(embarcacaoToUpdate);
    }

    public void deleteEmbarcacao(UUID id_embarcacao) {
        if (embarcacaoRepository.existsById(id_embarcacao)) {
            embarcacaoRepository.deleteById(id_embarcacao);
        } else {
            throw new RuntimeException("Embarcação com ID " + id_embarcacao + " não encontrada.");
        }
    }
}
