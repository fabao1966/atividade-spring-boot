package com.simple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple.entities.Estudante;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
    
}
