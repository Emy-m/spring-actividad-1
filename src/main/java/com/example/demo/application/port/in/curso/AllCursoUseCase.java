package com.example.demo.application.port.in.curso;

import com.example.demo.domain.Curso;

import java.time.LocalDate;
import java.util.List;

public interface AllCursoUseCase {
    List<Curso> findAll();

    List<Curso> findAllAfterDate(LocalDate date);
}
