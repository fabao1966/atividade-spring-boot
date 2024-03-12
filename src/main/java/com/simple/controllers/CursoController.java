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

import com.simple.entities.Curso;
import com.simple.repositories.CursoRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/curso")
@Slf4j
public class CursoController {

    @Autowired
    private CursoRepository repository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Curso> findAll() {
        log.info("Listing all cursos");
        List<Curso> result = repository.findAll();
        return result;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Curso cursoById(@PathVariable @Validated Long id) {
        log.info("Get cursos by id", id);
        var result = repository.findById(id).get();
        return result;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Curso insert(@RequestBody @Validated Curso curso) {
        log.info("Insert new curso", curso);
        Curso result = repository.save(curso);
        return result;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Curso update(@PathVariable @Validated Long id, @RequestBody @Validated Curso curso) {
        log.info("update course", curso);
        Curso res = cursoById(id);
        Curso result = repository.save(res);
        return result;
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCurso(@Validated @PathVariable Long id) {
        log.info("delete course by id", id);
        Curso result = cursoById(id);
        repository.delete(result);
    }

}
