package com.example.demo.adapter.in.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EstudianteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String DNI;
    private LocalDate fechaNacimiento;
}
