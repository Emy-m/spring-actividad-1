package com.example.demo.domain;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class Curso {
    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public String toString() {
        return "Curso(id=" + this.getId() + ", nombre=" + this.getNombre() + ", descripcion=" + this.getDescripcion() + ", fechaInicio=" + this.getFechaInicio() + ", fechaFin=" + this.getFechaFin() + ")";
    }
}
