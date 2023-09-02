package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class Inscripcion {
    private Long id;
    private LocalDate fechaDeInscripcion;
    private String estado;
    private Estudiante estudiante;
    private Curso curso;
}
