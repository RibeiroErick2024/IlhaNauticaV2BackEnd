package com.example.testsa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.testsa.entities.Endereco;
import com.example.testsa.repositories.EnderecoRepository;
import com.example.testsa.service.EnderecoService;

@ExtendWith(MockitoExtension.class)  
public class EnderecoServiceTest {

    @Mock
    private EnderecoRepository enderecoRepository;

    @InjectMocks
    private EnderecoService enderecoService;

    @Test
    public void testAdicionarEndereco_Success() {
        
        Endereco endereco = new Endereco();
        endereco.setCidade("São Paulo");
        endereco.setRua("Rua Teste");
        endereco.setBairro("Bairro Teste");
        endereco.setNumero(123);
        endereco.setEstado("SP");
        endereco.setLatitude(23.5505f);
        endereco.setLongitude(-46.6333f);

       
        when(enderecoRepository.save(any(Endereco.class))).thenReturn(endereco);

       
        Endereco result = enderecoService.adicionarEndereco(endereco);

        
        assertNotNull(result);
        assertEquals("São Paulo", result.getCidade());
        assertEquals("Rua Teste", result.getRua());
        assertEquals("Bairro Teste", result.getBairro());
        assertEquals(123, result.getNumero());
        assertEquals("SP", result.getEstado());
        assertEquals(23.5505f, result.getLatitude(), 0.01);
        assertEquals(-46.6333f, result.getLongitude(), 0.01);
    }

    @Test
    public void testBuscarTodosEnderecos_Success() {
        
        List<Endereco> listaEnderecos = new ArrayList<>();
        Endereco endereco1 = new Endereco();
        endereco1.setCidade("São Paulo");
        endereco1.setRua("Rua Teste 1");
        listaEnderecos.add(endereco1);

        when(enderecoRepository.findAll()).thenReturn(listaEnderecos);

        
        List<Endereco> result = enderecoService.buscarTodos();

        
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("São Paulo", result.get(0).getCidade());
    }

    @Test
    public void testAtualizarEndereco_Success() {
        
        UUID id = UUID.randomUUID();
        Endereco enderecoExistente = new Endereco();
        enderecoExistente.setIdEndereco(id);
        enderecoExistente.setRua("Rua Antiga");

        Endereco enderecoAtualizado = new Endereco();
        enderecoAtualizado.setRua("Rua Atualizada");

        when(enderecoRepository.findById(id)).thenReturn(Optional.of(enderecoExistente));
        when(enderecoRepository.saveAndFlush(any(Endereco.class))).thenReturn(enderecoAtualizado);

        
        Endereco result = enderecoService.atualizarEndereco(id, enderecoAtualizado);

        
        assertNotNull(result);
        assertEquals("Rua Atualizada", result.getRua());
    }

    @Test
    public void testDeletarEndereco_Success() {
        
        UUID id = UUID.randomUUID();

        
        enderecoService.deletarendereco(id);

        
        verify(enderecoRepository, times(1)).deleteById(id); 
    }
}
