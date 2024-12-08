package com.example.testsa.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Object> handleMethodNotAllowed(HttpRequestMethodNotSupportedException ex,
            HttpServletRequest request) {
        String method = request.getMethod();

        String errorMessage = String.format("Método %s não permitido para esta URL", method);

        return new ResponseEntity<>(errorMessage, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Object> handleBadCredentials(BadCredentialsException ex, HttpServletRequest request) {
        String message = ex.getMessage();

        String errorMessage = String.format("%s", message);

        return new ResponseEntity<>(errorMessage, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnexpectedErrors(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro inesperado: " + ex.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex,
            HttpServletRequest request) {
        // Verifica se a causa é uma violação de restrição (como chave duplicada)
        Throwable causa = ex.getCause();
    
        if (causa instanceof ConstraintViolationException) {
            ConstraintViolationException constraintException = (ConstraintViolationException) causa;
            
            // Mensagem do erro SQL contém detalhes sobre o índice violado
            String message = constraintException.getMessage();
    
            // Exemplo de mensagem: Unique index or primary key violation: "PUBLIC.CONSTRAINT_INDEX_22 ON PUBLIC.USUARIO(CPF_CNPJ NULLS FIRST) VALUES ('98765432109')"
            // Vamos extrair o nome da coluna que causou a violação (no caso, CPF_CNPJ)
            String chaveDuplicada = extractColumnFromViolationMessage(message);
            
            // Retorna uma mensagem detalhada
            String errorMessage = String.format("Verifique e forneça um '%s' válido e único.", chaveDuplicada);
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }
    
        // Caso não seja uma violação de chave, retorna mensagem genérica
        String errorMessage = "Erro de integridade no banco de dados. Verifique se há dados duplicados.";
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
    
    private String extractColumnFromViolationMessage(String message) {

        Pattern pattern = Pattern.compile("ON PUBLIC\\.USUARIO\\(([^)]+)\\)");
        Matcher matcher = pattern.matcher(message);
    
        if (matcher.find()) {
            String coluna = matcher.group(1); //nome da coluna
            return coluna.replaceAll("\\s+NULLS\\s+(FIRST|LAST)", "").trim();
        }
        return message; // Caso não encontre, retorna "Desconhecida"
    }

}