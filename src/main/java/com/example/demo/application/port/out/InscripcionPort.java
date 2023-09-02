package com.example.demo.application.port.out;

import com.example.demo.domain.Inscripcion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InscripcionPort {
    List<Inscripcion> findAllByEstadoIn(List<String> estados);

    @Query(value="SELECT * FROM inscripcion WHERE estado = :estado", nativeQuery = true)
    List<Inscripcion> findAllByEstadoEquals(@Param("estado") String estado);

    void save(Inscripcion inscripcion);
}
