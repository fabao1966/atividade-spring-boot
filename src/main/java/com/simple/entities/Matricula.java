package com.simple.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Matricula {
    private int id;
    private Curso curso;
    private Estudante estudante;
}
