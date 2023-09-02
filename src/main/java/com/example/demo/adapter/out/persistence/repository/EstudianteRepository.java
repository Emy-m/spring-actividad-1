package com.example.demo.adapter.out.persistence.repository;

import com.example.demo.adapter.out.persistence.entity.EstudianteEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstudianteRepository extends JpaRepository<EstudianteEntity, Long> {
    List<EstudianteEntity> findAllByOrderByDNIAsc(Pageable pageable);

    List<EstudianteEntity> findAllByDNIGreaterThanAndApellidoEquals(String DNI, String apellido);
}
