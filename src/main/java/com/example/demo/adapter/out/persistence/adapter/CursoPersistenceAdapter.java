package com.example.demo.adapter.out.persistence.adapter;

import com.example.demo.adapter.out.persistence.entity.CursoEntity;
import com.example.demo.adapter.out.persistence.mapper.CursoMapper;
import com.example.demo.adapter.out.persistence.repository.CursoRepository;
import com.example.demo.application.port.out.CursoPort;
import com.example.demo.common.PersistenceAdapter;
import com.example.demo.domain.Curso;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@PersistenceAdapter
public class CursoPersistenceAdapter implements CursoPort {

    private final CursoRepository cursoRepository;
    private final CursoMapper cursoMapper;

    @Override
    public Optional<Curso> findById(Long id) {
        Optional<CursoEntity> optionalCurso = cursoRepository.findById(id);

        return optionalCurso.isPresent() ? Optional.ofNullable(cursoMapper.mapToDomainEntity(optionalCurso.get())) : Optional.empty();
    }

    @Override
    public List<Curso> findAll() {
        List<CursoEntity> cursoEntities = cursoRepository.findAll();
        return cursoEntities.stream().map(cursoEntity -> cursoMapper.mapToDomainEntity(cursoEntity)).toList();
    }

    @Override
    public List<Curso> findAllByFechaInicioGreaterThan(LocalDate fechaInicio) {
        List<CursoEntity> cursoEntities = cursoRepository.findAllByFechaInicioGreaterThan(fechaInicio);
        return cursoEntities.stream().map(cursoEntity -> cursoMapper.mapToDomainEntity(cursoEntity)).toList();
    }
}
