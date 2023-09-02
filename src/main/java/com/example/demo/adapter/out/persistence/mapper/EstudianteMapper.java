package com.example.demo.adapter.out.persistence.mapper;

import com.example.demo.adapter.out.persistence.entity.EstudianteEntity;
import com.example.demo.domain.Estudiante;
import org.springframework.stereotype.Component;

@Component
public class EstudianteMapper {
    public Estudiante mapToDomainEntity(EstudianteEntity estudianteEntity) {
        return new Estudiante(
                estudianteEntity.getId(),
                estudianteEntity.getNombre(),
                estudianteEntity.getApellido(),
                estudianteEntity.getEmail(),
                estudianteEntity.getDNI(),
                estudianteEntity.getFechaNacimiento()
        );
    }

    public EstudianteEntity mapToJpaEntity(Estudiante estudiante) {
        return new EstudianteEntity(
                estudiante.getId(),
                estudiante.getNombre(),
                estudiante.getApellido(),
                estudiante.getEmail(),
                estudiante.getDNI(),
                estudiante.getFechaNacimiento()
        );
    }
}
