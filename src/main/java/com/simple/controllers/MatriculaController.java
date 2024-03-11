package com.simple.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.entities.Matricula;
import com.simple.repositories.MatriculaRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/matricula")
@Slf4j
public class MatriculaController {

    @Autowired
    private MatriculaRepository repository;

    @GetMapping
    public List<Matricula> findAll(){
        log.info("Listing all registration");
        List<Matricula> result = repository.findAll();        
        return result;
    }
    
}
