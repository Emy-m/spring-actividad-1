package com.example.demo.application.port.in.estudiante;

import com.example.demo.domain.Estudiante;

public interface UpdateEstudianteUseCase {
    void update(Long id, Estudiante estudiante);
}
