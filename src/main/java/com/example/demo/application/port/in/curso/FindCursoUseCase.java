package com.example.demo.application.port.in.curso;

import com.example.demo.domain.Curso;

public interface FindCursoUseCase {
    Curso findById(Long id);
}
