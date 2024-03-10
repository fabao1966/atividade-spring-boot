package com.simple.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simple.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    
}
