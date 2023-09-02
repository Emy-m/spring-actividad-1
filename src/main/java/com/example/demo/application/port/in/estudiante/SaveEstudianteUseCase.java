package com.example.demo.application.port.in.estudiante;

import com.example.demo.adapter.in.api.dto.EstudianteDTO;

public interface SaveEstudianteUseCase {
    void save(EstudianteDTO estudianteDTO);
}
