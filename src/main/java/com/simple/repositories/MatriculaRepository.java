package com.simple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple.entities.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    
}
