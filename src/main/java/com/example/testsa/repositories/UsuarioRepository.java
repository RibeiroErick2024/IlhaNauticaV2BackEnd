package com.example.testsa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID; 
import com.example.testsa.entities.Usuario;
// import com.github.f4b6a3.ulid.Ulid;


public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
   
    Optional<Usuario> findByEmail(String email);
    
}
