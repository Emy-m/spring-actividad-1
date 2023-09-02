package com.example.demo.application.port.out;

import com.example.demo.domain.Curso;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CursoPort {
    Optional<Curso> findById(Long id);

    List<Curso> findAll();

    List<Curso> findAllByFechaInicioGreaterThan(LocalDate fechaDeInicio);
}
