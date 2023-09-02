package com.example.demo.adapter.in.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class InscripcionDTO {
    private Long id;
    private String estado;
    private LocalDate fechaInscripcion;
    private Long estudiante;
    private Long curso;
}
