package com.example.demo.application.port.in.estudiante;

import com.example.demo.adapter.in.api.dto.EstudianteDTO;

import java.util.List;

public interface AllEstudianteUseCase {
    List<EstudianteDTO> findAll();

    List<EstudianteDTO> findAll(int page, int size);

    List<EstudianteDTO> findAllByDniGreaterThanAndApellidoEqualsRomero();
}
