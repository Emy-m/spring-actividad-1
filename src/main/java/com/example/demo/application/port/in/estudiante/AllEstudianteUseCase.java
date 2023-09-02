package com.example.demo.application.port.in.estudiante;

import com.example.demo.domain.Estudiante;

import java.util.List;

public interface AllEstudianteUseCase {
    List<Estudiante> findAll();

    List<Estudiante> findAll(int page, int size);

    List<Estudiante> findAllByDniGreaterThanAndApellidoEqualsRomero();
}
