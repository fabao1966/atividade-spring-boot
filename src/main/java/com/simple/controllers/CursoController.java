package com.simple.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.entities.Curso;
import com.simple.repositories.CursoRepository;

@RestController
@RequestMapping(value = "/curso")
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @GetMapping
    public List<Curso> findAll(){

        List<Curso> result = repository.findAll();
        return result;
    }
    
}
