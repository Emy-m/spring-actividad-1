package com.example.demo.application.service.estudiante;

import com.example.demo.application.port.in.estudiante.AllEstudianteUseCase;
import com.example.demo.application.port.out.EstudiantePort;
import com.example.demo.domain.Estudiante;
import com.example.demo.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@RequiredArgsConstructor
@UseCase
public class AllEstudianteService implements AllEstudianteUseCase {

    private final EstudiantePort estudiantePort;

    @Override
    public List<Estudiante> findAll() {
        return estudiantePort.findAll();
    }

    @Override
    public List<Estudiante> findAll(int page, int size) {
        return estudiantePort.findAllByOrderByDNIAsc(PageRequest.of(page, size));
    }

    @Override
    public List<Estudiante> findAllByDniGreaterThanAndApellidoEqualsRomero() {
        return estudiantePort.findAllByDNIGreaterThanAndApellidoEquals();
    }
}
