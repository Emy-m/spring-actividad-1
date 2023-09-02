package com.example.demo.application.service.estudiante;

import com.example.demo.application.port.in.estudiante.FindEstudianteUseCase;
import com.example.demo.application.port.out.EstudiantePort;
import com.example.demo.common.UseCase;
import com.example.demo.domain.Estudiante;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@UseCase
public class FindEstudianteService implements FindEstudianteUseCase {

    private final EstudiantePort estudiantePort;

    @Override
    public Estudiante findById(Long id) {
        Optional<Estudiante> estudianteOptional = estudiantePort.findById(id);

        if (estudianteOptional.isEmpty()) {
            throw new RuntimeException("Id invalido");
        }

        return estudianteOptional.get();
    }
}
