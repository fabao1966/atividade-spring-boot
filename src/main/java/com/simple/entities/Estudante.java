package com.simple.entities;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Estudante {
    private int id;
    private String nome;
    private Date dataMatricula;
}
