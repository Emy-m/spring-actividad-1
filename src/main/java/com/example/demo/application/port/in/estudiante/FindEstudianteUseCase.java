package com.example.demo.application.port.in.estudiante;

import com.example.demo.domain.Estudiante;

public interface FindEstudianteUseCase {
    Estudiante findById(Long id);
}
