package com.example.demo.adapter.out.persistence.mapper;

import com.example.demo.adapter.out.persistence.entity.CursoEntity;
import com.example.demo.domain.Curso;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {
    public Curso mapToDomainEntity(CursoEntity cursoEntity) {
        return new Curso(
                cursoEntity.getId(),
                cursoEntity.getNombre(),
                cursoEntity.getDescripcion(),
                cursoEntity.getFechaInicio(),
                cursoEntity.getFechaFin()
        );
    }

    public CursoEntity mapToJpaEntity(Curso curso) {
        return new CursoEntity(
                curso.getId(),
                curso.getNombre(),
                curso.getDescripcion(),
                curso.getFechaInicio(),
                curso.getFechaFin()
        );
    }
}
