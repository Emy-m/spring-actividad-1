package com.example.demo.adapter.out.persistence.adapter;

import com.example.demo.adapter.out.persistence.entity.InscripcionEntity;
import com.example.demo.adapter.out.persistence.mapper.InscripcionMapper;
import com.example.demo.adapter.out.persistence.repository.InscripcionRepository;
import com.example.demo.application.port.out.InscripcionPort;
import com.example.demo.common.PersistenceAdapter;
import com.example.demo.domain.Inscripcion;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@PersistenceAdapter
public class InscripcionPersistenceAdapter implements InscripcionPort {

    private final InscripcionRepository inscripcionRepository;
    private final InscripcionMapper inscripcionMapper;

    @Override
    public List<Inscripcion> findAllByEstadoIn(List<String> estados) {
        List<InscripcionEntity> inscripcionEntities = inscripcionRepository.findAllByEstadoIn(estados);
        return inscripcionEntities.stream().map(inscripcionEntity -> inscripcionMapper.mapToDomainEntity(inscripcionEntity)).toList();
    }

    @Override
    public List<Inscripcion> findAllByEstadoEquals(String estado) {
        List<InscripcionEntity> inscripcionEntities = inscripcionRepository.findAllByEstadoEquals(estado);
        return inscripcionEntities.stream().map(inscripcionEntity -> inscripcionMapper.mapToDomainEntity(inscripcionEntity)).toList();
    }

    @Override
    public void save(Inscripcion inscripcion) {
        InscripcionEntity inscripcionEntity = inscripcionMapper.mapToJpaEntity(inscripcion);
        inscripcionRepository.save(inscripcionEntity);
    }
}
