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

import com.example.testsa.entities.Usuario;
import com.example.testsa.repositories.UsuarioRepository;
import com.example.testsa.service.UsuarioService;

public class LoginServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    private Usuario usuario;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        usuario = new Usuario();
        usuario.setId(UUID.randomUUID());
        usuario.setEmail("admin@123.com.br");
        usuario.setSenha("senha123");
        usuario.setNomeCompleto("Test User");
    }

    @Test
    void testLoginUsuario_Success() {
        
        when(usuarioRepository.findByEmail("admin@123.com.br")).thenReturn(Optional.of(usuario));

        
        Usuario result = usuarioService.loginUsuario("admin@123.com.br", "senha123");

        
        assertNotNull(result);
        assertEquals(usuario.getEmail(), result.getEmail());
        assertEquals(usuario.getSenha(), result.getSenha());
    }

    @Test
    void testLoginUsuario_UsuarioNaoEncontrado() {
        
        when(usuarioRepository.findByEmail("admin@123.com.br")).thenReturn(Optional.empty());

       
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            usuarioService.loginUsuario("admin@123.com.br", "senha123");
        });

        assertEquals("Usuário não encontrado!", thrown.getMessage());
    }

    @Test
    void testLoginUsuario_SenhaInvalida() {
        
        when(usuarioRepository.findByEmail("admin@123.com.br")).thenReturn(Optional.of(usuario));

        
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            usuarioService.loginUsuario("admin@123.com.br", "senhaErrada");
        });

        assertEquals("Senha inválida!", thrown.getMessage());
    }

    @Test
    void testCriarUsuario_Success() {
        
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);

       
        Usuario result = usuarioService.criarUsuario(usuario);

       
        assertNotNull(result);
        assertEquals(usuario.getNomeCompleto(), result.getNomeCompleto());
        assertEquals(usuario.getEmail(), result.getEmail());
    }
}