package com.simple.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Curso {
    private int id;
    private String titulo;
    private int creditos;
}
