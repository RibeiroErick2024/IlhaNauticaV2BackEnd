// package com.example.testsa;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.test.context.ActiveProfiles;

// import com.example.testsa.controller.UsuarioController;
// import com.example.testsa.controller.Auth.AuthenticationController;
// import com.example.testsa.dto.req.LoginDTO;
// import com.example.testsa.service.UsuarioService;

// import jakarta.transaction.Transactional;

// @DataJpaTest
// @ActiveProfiles("test")
// @Transactional
// public class LoginDTOTest {
//     @Autowired
//     UsuarioService usuarioService;
//     @Test
//     public void testGetToken() {
        
//         AuthenticationController authenticationController = new AuthenticationController(null, null);
//         UsuarioController usuarioController;

//         LoginDTO logindto = new LoginDTO();
//         logindto.setEmail("teste@email.com");
//         logindto.setSenha("teste123");

//         authenticationController.login(logindto);



//     }


// }
