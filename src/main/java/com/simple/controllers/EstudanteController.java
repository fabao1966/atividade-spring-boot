package com.simple.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simple.repositories.EstudanteRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/estudante")
@Slf4j
public class EstudanteController {

    @Autowired
    private EstudanteRepository repository;

    @GetMapping
    public String findAll(){
        return "Lista de estudantes";
    }
    
}
