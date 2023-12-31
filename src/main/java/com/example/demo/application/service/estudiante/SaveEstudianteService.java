package com.example.demo.application.service.estudiante;

import com.example.demo.application.port.in.estudiante.SaveEstudianteUseCase;
import com.example.demo.application.port.out.EstudiantePort;
import com.example.demo.common.UseCase;
import com.example.demo.domain.Estudiante;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class SaveEstudianteService implements SaveEstudianteUseCase {

    private final EstudiantePort estudiantePort;

    @Override
    public void save(Estudiante estudiante) {
        estudiantePort.save(estudiante);
    }
}
