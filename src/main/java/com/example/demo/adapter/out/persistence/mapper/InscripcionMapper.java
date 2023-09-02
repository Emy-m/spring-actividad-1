package com.example.demo.adapter.out.persistence.mapper;

import com.example.demo.adapter.out.persistence.entity.InscripcionEntity;
import com.example.demo.domain.Inscripcion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InscripcionMapper {
    private final EstudianteMapper estudianteMapper;
    private final CursoMapper cursoMapper;

    public Inscripcion mapToDomainEntity(InscripcionEntity inscripcionEntity) {
        return new Inscripcion(
                inscripcionEntity.getId(),
                inscripcionEntity.getFechaDeInscripcion(),
                inscripcionEntity.getEstado(),
                estudianteMapper.mapToDomainEntity(inscripcionEntity.getEstudiante()),
                cursoMapper.mapToDomainEntity(inscripcionEntity.getCurso())
        );
    }

    public InscripcionEntity mapToJpaEntity(Inscripcion inscripcion) {
        return new InscripcionEntity(
                inscripcion.getId(),
                inscripcion.getFechaDeInscripcion(),
                inscripcion.getEstado(),
                estudianteMapper.mapToJpaEntity(inscripcion.getEstudiante()),
                cursoMapper.mapToJpaEntity(inscripcion.getCurso())
        );
    }
}
