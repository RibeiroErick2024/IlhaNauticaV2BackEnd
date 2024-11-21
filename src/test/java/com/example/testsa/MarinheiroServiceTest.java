package com.example.testsa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.testsa.entities.Marinheiro;
import com.example.testsa.repositories.MarinheiroRepository;
import com.example.testsa.service.MarinheiroService;

class MarinheiroServiceTest {

    @InjectMocks
    private MarinheiroService marinheiroService;

    @Mock
    private MarinheiroRepository marinheiroRepository;

    private Marinheiro marinheiro;
    private UUID marinheiroId;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        marinheiroId = UUID.randomUUID();
        marinheiro = new Marinheiro();
        marinheiro.setIdMarinheiro(marinheiroId);
        marinheiro.setNome("João Silva");
        marinheiro.setCategoria("Cabo");
        marinheiro.setAnosExperiencia(5);
        marinheiro.setDisponibilidade("Disponível");
        marinheiro.setRegistroMaritimo("12345");
    }

    @Test
    void testCadastrarMarinheiro_Success() {
        
        when(marinheiroRepository.save(any(Marinheiro.class))).thenReturn(marinheiro);

        
        Marinheiro result = marinheiroService.cadastrar(marinheiro);

        
        assertNotNull(result);
        assertEquals(marinheiro.getNome(), result.getNome());
        assertEquals(marinheiro.getCategoria(), result.getCategoria());
        assertEquals(marinheiro.getAnosExperiencia(), result.getAnosExperiencia());
        assertEquals(marinheiro.getDisponibilidade(), result.getDisponibilidade());
        assertEquals(marinheiro.getRegistroMaritimo(), result.getRegistroMaritimo());
    }

    @Test
    void testBuscarPorId_Success() {
        
        when(marinheiroRepository.findById(marinheiroId)).thenReturn(Optional.of(marinheiro));

        
        Marinheiro result = marinheiroService.buscarPorId(marinheiroId);

        
        assertNotNull(result);
        assertEquals(marinheiroId, result.getIdMarinheiro());
        assertEquals(marinheiro.getNome(), result.getNome());
    }

    @Test
    void testBuscarPorId_MarinheiroNaoEncontrado() {
        
        when(marinheiroRepository.findById(marinheiroId)).thenReturn(Optional.empty());

        
        Marinheiro result = marinheiroService.buscarPorId(marinheiroId);
        assertNull(result);
    }

    @Test
    void testAtualizarMarinheiro_Success() {
       
        when(marinheiroRepository.findById(marinheiroId)).thenReturn(Optional.of(marinheiro));
        when(marinheiroRepository.saveAndFlush(any(Marinheiro.class))).thenReturn(marinheiro);

        
        marinheiro.setNome("João Pedro Silva");
        marinheiro.setCategoria("Sargento");

        
        Marinheiro result = marinheiroService.atualizarMarinheiro(marinheiroId, marinheiro);

        
        assertNotNull(result);
        assertEquals("João Pedro Silva", result.getNome());
        assertEquals("Sargento", result.getCategoria());
    }
}