package com.example.demo.application.service.estudiante;

import com.example.demo.adapter.in.api.dto.EstudianteDTO;
import com.example.demo.application.port.in.estudiante.AllEstudianteUseCase;
import com.example.demo.application.port.out.EstudiantePort;
import com.example.demo.common.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;

import java.util.List;

@RequiredArgsConstructor
@UseCase
public class AllEstudianteService implements AllEstudianteUseCase {

    private final EstudiantePort estudiantePort;

    @Override
    public List<EstudianteDTO> findAll() {
        return estudiantePort.findAll().stream().map(e -> new EstudianteDTO(
                e.getId(), e.getNombre(), e.getApellido(), e.getEmail(), e.getDNI(), e.getFechaNacimiento()
        )).toList();
    }

    @Override
    public List<EstudianteDTO> findAll(int page, int size) {
        return estudiantePort.findAllByOrderByDNIAsc(PageRequest.of(page, size)).stream().map(e -> new EstudianteDTO(
                e.getId(), e.getNombre(), e.getApellido(), e.getEmail(), e.getDNI(), e.getFechaNacimiento()
        )).toList();
    }

    @Override
    public List<EstudianteDTO> findAllByDniGreaterThanAndApellidoEqualsRomero() {
        return estudiantePort.findAllByDNIGreaterThanAndApellidoEquals().stream().map(e -> new EstudianteDTO(
                e.getId(), e.getNombre(), e.getApellido(), e.getEmail(), e.getDNI(), e.getFechaNacimiento()
        )).toList();
    }
}
