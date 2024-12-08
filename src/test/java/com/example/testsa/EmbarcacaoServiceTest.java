package com.example.testsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.testsa.converter.EmbarcacaoConverter;
import com.example.testsa.converter.UsuarioConverter;
import com.example.testsa.dto.req.EmbarcacaoDTOReq;
import com.example.testsa.dto.res.Embarcacao.EmbarcacaoDTORes;
import com.example.testsa.entities.Embarcacao;
import com.example.testsa.entities.Usuario;
import com.example.testsa.repositories.EmbarcacaoRepository;
import com.example.testsa.repositories.UsuarioRepository;
import com.example.testsa.service.EmbarcacaoService;

@ExtendWith(MockitoExtension.class)
public class EmbarcacaoServiceTest {

    @Mock
    private EmbarcacaoRepository embarcacaoRepository;
    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private EmbarcacaoService embarcacaoService;

    @Test
    public void testCriarEmbarcacao_Successo() {
     
        Usuario usuario = new Usuario();
        usuario.setId(UUID.randomUUID());
        usuario.setEmail("email@exemplo.com");
        usuario.setNomeCompleto("Exemplo Email");

       
        EmbarcacaoDTOReq embarcacao = new EmbarcacaoDTOReq();
        embarcacao.setNome("Hornet 500");
        embarcacao.setAnoFabricacao(2024);
        embarcacao.setPreco(50000);
        embarcacao.setUsuario(UsuarioConverter.usuarioConverterSimples(usuario)); 

        when(usuarioRepository.findById(usuario.getId())).thenReturn(Optional.of(usuario));

        when(embarcacaoRepository.save(any(Embarcacao.class))).thenReturn(EmbarcacaoConverter.dtoConverterEntidade(embarcacao));

        EmbarcacaoDTORes result = embarcacaoService.criarEmbarcacao(embarcacao);

        assertNotNull(result);
        assertEquals("Hornet 500", result.getNome());
        assertEquals(2024, result.getAnoFabricacao());
        assertEquals(50000, result.getPreco(), 0.01);
        // assertEquals(usuario, result.getUsuario());
    }


    @Test
    public void testBuscarEmbarcacaoPorId_Success() {
        UUID id = UUID.randomUUID();
        Embarcacao embarcacao = new Embarcacao();
        embarcacao.setIdEmbarcacao(id);
        embarcacao.setNome("Hornet 500");

        when(embarcacaoRepository.findById(id)).thenReturn(Optional.of(embarcacao));

        Embarcacao result = embarcacaoService.buscarEmbarcacaoPorId(id);

        assertNotNull(result);
        assertEquals(id, result.getIdEmbarcacao());
        assertEquals("Hornet 500", result.getNome());
    }

    @Test
    public void testBuscarEmbarcacaoPorId_NaoEncontrado() {
        UUID id = UUID.randomUUID();
        when(embarcacaoRepository.findById(id)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            embarcacaoService.buscarEmbarcacaoPorId(id);
        });

        assertEquals("Embarcação com ID " + id + " não encontrada.", exception.getMessage());
    }

    @Test
    public void testAtualizarEmbarcacao_Successo() {
        
        Usuario usuario = new Usuario();
        usuario.setId(UUID.randomUUID());
        usuario.setEmail("email@exemplo.com");
        usuario.setNomeCompleto("Exemplo Email");
        
        UUID id = UUID.randomUUID();
        Embarcacao embarcacaoExistente = new Embarcacao();
        embarcacaoExistente.setIdEmbarcacao(id);
        embarcacaoExistente.setNome("Embarcação Antiga");
        embarcacaoExistente.setUsuario(usuario); 
        
        EmbarcacaoDTOReq embarcacaoAtualizada = new EmbarcacaoDTOReq();
        embarcacaoAtualizada.setNome("Embarcação Atualizada");
        embarcacaoAtualizada.setAnoFabricacao(2025);
        embarcacaoAtualizada.setUsuario(UsuarioConverter.usuarioConverterSimples(usuario)); 
        
        when(embarcacaoRepository.findById(id)).thenReturn(Optional.of(embarcacaoExistente));
        when(embarcacaoRepository.saveAndFlush(any(Embarcacao.class))).thenReturn(EmbarcacaoConverter.dtoConverterEntidade(embarcacaoAtualizada));

        EmbarcacaoDTORes result = embarcacaoService.atualizarEmbarcacao(id, embarcacaoAtualizada);

        assertNotNull(result);
        assertEquals("Embarcação Atualizada", result.getNome());
        assertEquals(2025, result.getAnoFabricacao());
    }

    @Test
    public void testAtualizarEmbarcacao_IdNaoExistente() {
        UUID idInexistente = UUID.randomUUID();
        EmbarcacaoDTOReq embarcacaoAtualizada = new EmbarcacaoDTOReq();
        embarcacaoAtualizada.setNome("Embarcação Atualizada");
        embarcacaoAtualizada.setAnoFabricacao(2025);
        embarcacaoAtualizada.setUsuario(null);
        when(embarcacaoRepository.findById(idInexistente)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> {
            embarcacaoService.atualizarEmbarcacao(idInexistente, embarcacaoAtualizada);
        });

        assertEquals("Embarcação com ID " + idInexistente + " não encontrada.", exception.getMessage());
        verify(embarcacaoRepository, never()).saveAndFlush(any(Embarcacao.class));
    }

    @Test
    public void testDeletarEmbarcacao_IdNaoExistente() {
        UUID idInexistente = UUID.randomUUID();

        when(embarcacaoRepository.findById(idInexistente)).thenThrow(RuntimeException.class);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            embarcacaoService.deleteEmbarcacao(idInexistente);
        });

        verify(embarcacaoRepository, never()).deleteById(any(UUID.class));
    }
}
