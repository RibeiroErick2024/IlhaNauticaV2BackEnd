// package com.example.testsa.exceptions;

// import java.util.HashMap;
// import java.util.Map;

// import org.springframework.dao.DataIntegrityViolationException;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.ControllerAdvice;
// import org.springframework.web.bind.annotation.ExceptionHandler;

// @ControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(DataIntegrityViolationException.class)
//     public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
//         Map<String, Object> body = new HashMap<>();
//         body.put("status", HttpStatus.CONFLICT.value());
//         body.put("error", "Data Integrity Violation");
    
//         // Obter a mensagem da exceção
//         String message = ex.getMessage().toLowerCase(); // Converte para minúsculas para facilitar a comparação
    
//         // Verificar se a mensagem contém informações sobre CPF ou e-mail
//         if (message.contains("cpf") || message.contains("cnpj")) {
//             body.put("message", "O CPF/CNPJ informado já existe no sistema.");
//         } else if (message.contains("email")) {
//             body.put("message", "O e-mail informado já existe no sistema.");
//         } else {
//             body.put("message", "Um campo único foi violado.");
//         }
    
//         body.put("timestamp", System.currentTimeMillis());
    
//         return new ResponseEntity<>(body, HttpStatus.CONFLICT);
//     }
    
// }
