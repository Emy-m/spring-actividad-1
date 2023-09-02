package com.example.demo.adapter.out.persistence.repository;

import com.example.demo.adapter.out.persistence.entity.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CursoRepository  extends JpaRepository<CursoEntity, Long> {
    List<CursoEntity> findAllByFechaInicioGreaterThan(LocalDate fechaInicio);
}
