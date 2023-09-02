package com.example.demo.adapter.out.persistence.repository;

import com.example.demo.adapter.out.persistence.entity.InscripcionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscripcionRepository extends JpaRepository<InscripcionEntity, Long> {
    List<InscripcionEntity> findAllByEstadoIn(List<String> estados);

    List<InscripcionEntity> findAllByEstadoEquals(String estado);
}
