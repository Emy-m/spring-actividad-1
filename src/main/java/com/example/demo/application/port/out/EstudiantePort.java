package com.example.demo.application.port.out;


import com.example.demo.domain.Estudiante;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EstudiantePort {
    Optional<Estudiante> findById(Long id);

    List<Estudiante> findAll();

    List<Estudiante> findAllByOrderByDNIAsc(Pageable pageable);

    List<Estudiante> findAllByDNIGreaterThanAndApellidoEquals();

    void save(Estudiante estudiante);

    void update(Long id, Estudiante estudiante);

    void deleteById(Long id);
}
