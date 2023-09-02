package com.example.demo.application.port.in.inscripcion;

import com.example.demo.domain.Inscripcion;

import java.util.List;

public interface AllInscripcionUseCase {
    List<Inscripcion> findAllRechazadaOrPendiente();

    List<Inscripcion> findAllByEstado(String estado);
}
