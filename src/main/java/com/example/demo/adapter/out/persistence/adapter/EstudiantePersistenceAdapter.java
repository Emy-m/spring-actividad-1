package com.example.demo.adapter.out.persistence.adapter;

import com.example.demo.adapter.out.persistence.entity.EstudianteEntity;
import com.example.demo.adapter.out.persistence.mapper.EstudianteMapper;
import com.example.demo.adapter.out.persistence.repository.EstudianteRepository;
import com.example.demo.application.port.out.EstudiantePort;
import com.example.demo.common.PersistenceAdapter;
import com.example.demo.domain.Estudiante;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@PersistenceAdapter
public class EstudiantePersistenceAdapter implements EstudiantePort {

    public final EstudianteRepository estudianteRepository;
    public final EstudianteMapper estudianteMapper;

    @Override
    public Optional<Estudiante> findById(Long id) {
        Optional<EstudianteEntity> optionalEstudiante = estudianteRepository.findById(id);
        return optionalEstudiante.isPresent() ? Optional.ofNullable(estudianteMapper.mapToDomainEntity(optionalEstudiante.get())) : Optional.empty();
    }

    @Override
    public List<Estudiante> findAll() {
        List<EstudianteEntity> estudianteEntities = estudianteRepository.findAll();
        return estudianteEntities.stream().map(estudianteEntity -> estudianteMapper.mapToDomainEntity(estudianteEntity)).toList();
    }

    @Override
    public List<Estudiante> findAllByOrderByDNIAsc(Pageable pageable) {
        List<EstudianteEntity> estudianteEntities = estudianteRepository.findAllByOrderByDNIAsc(pageable);
        return estudianteEntities.stream().map(estudianteEntity -> estudianteMapper.mapToDomainEntity(estudianteEntity)).toList();
    }

    @Override
    public List<Estudiante> findAllByDNIGreaterThanAndApellidoEquals() {
        String dni = "20000000";
        String apellido = "Romero";
        List<EstudianteEntity> estudianteEntities = estudianteRepository.findAllByDNIGreaterThanAndApellidoEquals(dni, apellido);
        return estudianteEntities.stream().map(estudianteEntity -> estudianteMapper.mapToDomainEntity(estudianteEntity)).toList();
    }

    @Override
    public void save(Estudiante estudiante) {
        EstudianteEntity estudianteEntity = estudianteMapper.mapToJpaEntity(estudiante);
        estudianteRepository.save(estudianteEntity);
    }

    @Override
    public void update(Long id, Estudiante estudiante) {
        EstudianteEntity estudianteEntity = estudianteMapper.mapToJpaEntity(estudiante);
        estudianteEntity.setId(id);
        estudianteRepository.save(estudianteEntity);
    }

    @Override
    public void deleteById(Long id) {
        estudianteRepository.deleteById(id);
    }
}
