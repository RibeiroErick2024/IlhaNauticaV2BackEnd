package com.example.testsa.repositories;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testsa.entities.Marinheiro;


public interface MarinheiroRepository extends JpaRepository<Marinheiro, UUID> {
    
}
