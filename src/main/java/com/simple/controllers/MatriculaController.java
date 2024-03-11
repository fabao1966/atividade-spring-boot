package com.simple.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.entities.Curso;
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

     
    @GetMapping("/{id}")
    public Matricula MatriculaById(@PathVariable @Validated Long id){
        log.info("Get registration by id", id);

        var  result =  repository.findById(id).get();

        return result;
    }
    
}
