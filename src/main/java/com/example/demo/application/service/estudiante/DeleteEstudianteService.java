package com.example.demo.application.service.estudiante;

import com.example.demo.application.port.in.estudiante.DeleteEstudianteUseCase;
import com.example.demo.application.port.out.EstudiantePort;
import com.example.demo.common.UseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class DeleteEstudianteService implements DeleteEstudianteUseCase {

    private final EstudiantePort estudiantePort;

    @Override
    public void delete(Long id) {
        estudiantePort.deleteById(id);
    }
}
