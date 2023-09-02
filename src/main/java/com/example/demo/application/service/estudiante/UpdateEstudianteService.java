package com.example.demo.application.service.estudiante;

import com.example.demo.application.port.in.estudiante.UpdateEstudianteUseCase;
import com.example.demo.application.port.out.EstudiantePort;
import com.example.demo.common.UseCase;
import com.example.demo.domain.Estudiante;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class UpdateEstudianteService implements UpdateEstudianteUseCase {

    private final EstudiantePort estudiantePort;

    @Override
    public void update(Long id, Estudiante estudiante) {
        estudiantePort.update(id, estudiante);
    }
}
