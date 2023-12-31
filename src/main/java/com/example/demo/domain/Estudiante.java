package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class Estudiante {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String DNI;
    private LocalDate fechaNacimiento;
}
