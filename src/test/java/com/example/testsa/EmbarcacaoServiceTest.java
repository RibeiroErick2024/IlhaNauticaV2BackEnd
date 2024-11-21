package com.example.testsa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.testsa.entities.Embarcacao;
import com.example.testsa.repositories.EmbarcacaoRepository;
import com.example.testsa.service.EmbarcacaoService;

@ExtendWith(MockitoExtension.class) 
public class EmbarcacaoServiceTest {

    @Mock
    private EmbarcacaoRepository embarcacaoRepository;

    @InjectMocks
    private EmbarcacaoService embarcacaoService;

    @Test
    public void testCriarEmbarcacao_Successo() {
        
        Embarcacao embarcacao = new Embarcacao();
        embarcacao.setNome("Hornet 500");
        embarcacao.setAnoFabricacao(2024);
        embarcacao.setPreco(50000);

        
        when(embarcacaoRepository.save(any(Embarcacao.class))).thenReturn(embarcacao);

        
        Embarcacao result = embarcacaoService.creatEmbarcacao(embarcacao);

        
        assertNotNull(result);
        assertEquals("Hornet 500", result.getNome());
        assertEquals(2024, result.getAnoFabricacao());
        assertEquals(50000, result.getPreco(), 0.01);
    }

    @Test
    public void testBuscarEmbarcacaoPorId_Success() {
        
        UUID id = UUID.randomUUID();
        Embarcacao embarcacao = new Embarcacao();
        embarcacao.setIdEmbarcacao(id);
        embarcacao.setNome("Hornet 500");

        when(embarcacaoRepository.findById(id)).thenReturn(Optional.of(embarcacao));

       
        Embarcacao result = embarcacaoService.getEmbarcacaoById(id);

        
        assertNotNull(result);
        assertEquals(id, result.getIdEmbarcacao());
        assertEquals("Hornet 500", result.getNome());
    }

    @Test
    public void testBuscarEmbarcacaoPorId_NaoEncontrado() {
        
        UUID id = UUID.randomUUID();
        when(embarcacaoRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        Embarcacao result = embarcacaoService.getEmbarcacaoById(id);

        
        assertNull(result);
    }

    @Test
    public void testAtualizarEmbarcacao_Successo() {
        
        UUID id = UUID.randomUUID();
        Embarcacao embarcacaoExistente = new Embarcacao();
        embarcacaoExistente.setIdEmbarcacao(id);
        embarcacaoExistente.setNome("Embarcação Antiga");

        Embarcacao embarcacaoAtualizada = new Embarcacao();
        embarcacaoAtualizada.setNome("Embarcação Atualizada");
        embarcacaoAtualizada.setAnoFabricacao(2025);

        when(embarcacaoRepository.findById(id)).thenReturn(Optional.of(embarcacaoExistente));
        when(embarcacaoRepository.saveAndFlush(any(Embarcacao.class))).thenReturn(embarcacaoAtualizada);

        
        Embarcacao result = embarcacaoService.updateEmbarcacao(id, embarcacaoAtualizada);

        
        assertNotNull(result);
        assertEquals("Embarcação Atualizada", result.getNome());
        assertEquals(2025, result.getAnoFabricacao());
    }
}
