package com.simple.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    @ResponseStatus(HttpStatus.OK)
    public List<Matricula> findAll() {
        log.info("Listing all registration");
        List<Matricula> result = repository.findAll();
        return result;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Matricula matriculaById(@PathVariable @Validated Long id) {
        log.info("Get registration by id", id);
        var result = repository.findById(id).get();
        return result;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Matricula insert(@RequestBody @Validated Matricula matricula) {
        log.info("Insert new registration", matricula);
        Matricula result = repository.save(matricula);
        return result;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Matricula update(@RequestBody @Validated Matricula matricula) {
        log.info("update registration", matricula);
        Matricula result = repository.save(matricula);
        return result;
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@Validated @PathVariable Long id) {
        log.info("delete registration by id", id);
        Matricula result = matriculaById(id);
        repository.delete(result);
    }

}
