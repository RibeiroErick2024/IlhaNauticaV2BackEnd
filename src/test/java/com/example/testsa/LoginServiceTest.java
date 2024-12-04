// package com.example.testsa;

// import static org.junit.jupiter.api.Assertions.*;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.when;

// import java.util.Optional;
// import java.util.UUID;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.BadCredentialsException;
// import org.springframework.security.crypto.password.PasswordEncoder;

// import com.example.testsa.dto.req.LoginDTO;
// import com.example.testsa.dto.req.Usuario.CadastroUsuarioDTO;
// import com.example.testsa.entities.Usuario;
// import com.example.testsa.repositories.UsuarioRepository;
// import com.example.testsa.service.AuthenticationService;
// import com.example.testsa.service.UsuarioService;

// public class LoginServiceTest {

//     @Mock
//     private UsuarioRepository usuarioRepository;

//     @Mock
//     private PasswordEncoder passwordEncoder;
//     @Mock
//     private AuthenticationManager authenticationManager;

//     @InjectMocks
//     private UsuarioService usuarioService;
//     @InjectMocks
//     private AuthenticationService authenticationService;

//     private Usuario usuario;

//     @BeforeEach
//     void setUp() {
//         MockitoAnnotations.openMocks(this);
//         usuario = new Usuario();
//         usuario.setId(UUID.randomUUID());
//         usuario.setEmail("admin@123.com.br");
//         usuario.setSenha("senha123");
//         usuario.setNomeCompleto("Test User");

//         String senhaCriptografada = "encodedPassword";
//         when(passwordEncoder.encode(usuario.getSenha())).thenReturn(senhaCriptografada); 
//         usuario.setSenha(senhaCriptografada);
//     }

//     @Test
//     void testCriarUsuario_Success() { 

//         CadastroUsuarioDTO cadastro = new CadastroUsuarioDTO();
//         cadastro.setEmail(usuario.getEmail());
//         cadastro.setSenha(usuario.getSenha());
//         cadastro.setNomeCompleto(usuario.getNomeCompleto());

//         when(usuarioRepository.findByEmail(cadastro.getEmail())).thenReturn(null);  // Email não existe
//         when(passwordEncoder.encode(cadastro.getSenha())).thenReturn("encodedPassword");  // Senha criptografada

      
//         when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);  

//         Usuario result = authenticationService.signup(cadastro);

//         assertNotNull(result); 
//         assertEquals(cadastro.getEmail(), result.getEmail());  
//         assertEquals(cadastro.getNomeCompleto(), result.getNomeCompleto()); 

//     }
    
// //adicionar cenário de falha/ usuario já existe
//     @Test
//     void testCriarUsuario_Failure_UsuarioJaExiste() {
        
//         CadastroUsuarioDTO cadastro = new CadastroUsuarioDTO();
//         cadastro.setEmail(usuario.getEmail());
//         cadastro.setSenha(usuario.getSenha());
//         cadastro.setNomeCompleto(usuario.getNomeCompleto());
    
        
//         when(usuarioRepository.findByEmail(cadastro.getEmail())).thenReturn(Optional.of(usuario));
    
        
//         assertThrows(BadCredentialsException.class, () -> authenticationService.signup(cadastro));
//     }
    

//     @Test
//     void testLoginUsuario_Success() {
        
               
//         when(usuarioRepository.findByEmail("admin@123.com.br")).thenReturn(Optional.of(usuario));
       
//         when(passwordEncoder.matches("senha123", usuario.getSenha())).thenReturn(true);
       
//         LoginDTO login = new LoginDTO();
//         login.setEmail("admin@123.com.br");
//         login.setSenha("senha123");
//         Usuario result = authenticationService.authenticate(login);

//         assertNotNull(result);
//         assertEquals(usuario.getEmail(), result.getEmail());
//         assertEquals(usuario.getSenha(), result.getSenha());
//     }

//     @Test
//     void testLoginUsuario_UsuarioNaoEncontrado() {

//         when(usuarioRepository.findByEmail("admin@123.com.br")).thenReturn(Optional.empty());
//         LoginDTO login = new LoginDTO();
//         login.setEmail("admin@123.com.br");
//         login.setSenha("senha123");
        

//         BadCredentialsException thrown = assertThrows(BadCredentialsException.class, () -> {
//             authenticationService.authenticate(login);
//         });

//         assertEquals("Email não encontrado", thrown.getMessage());
//     }

//     @Test
//     void testLoginUsuario_SenhaInvalida() {

//         when(usuarioRepository.findByEmail("admin@123.com.br")).thenReturn(Optional.of(usuario));

//         LoginDTO login = new LoginDTO();
//         login.setEmail("admin@123.com.br");
//         login.setSenha("senhaErrada");

//         BadCredentialsException thrown = assertThrows(BadCredentialsException.class, () -> {
//             authenticationService.authenticate(login);
//         });

//         assertEquals("Senha incorreta", thrown.getMessage());
//     }

  
// }