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

import com.simple.entities.Estudante;
import com.simple.repositories.EstudanteRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/estudante")
@Slf4j
public class EstudanteController {

    @Autowired
    private EstudanteRepository repository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Estudante> findAll() {
        log.info("Listing all students");
        List<Estudante> result = repository.findAll();
        return result;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Estudante estudanteById(@PathVariable @Validated Long id) {
        log.info("Get students by id", id);
        var result = repository.findById(id).get();
        return result;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estudante insert(@RequestBody @Validated Estudante estudante) {
        log.info("Insert new student", estudante);
        Estudante result = repository.save(estudante);
        return result;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Estudante update(@PathVariable @Validated Long id, @RequestBody @Validated Estudante estudante) {
        log.info("update student", estudante);
        Estudante res = estudanteById(id);
        Estudante result = repository.save(res);
        return result;
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCurso(@Validated @PathVariable Long id) {
        log.info("delete student by id", id);
        Estudante result = estudanteById(id);
        repository.delete(result);

    }

}
