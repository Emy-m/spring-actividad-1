package com.example.demo.application.port.in.inscripcion;

import com.example.demo.adapter.in.api.dto.InscripcionDTO;

import java.util.List;

public interface AllInscripcionUseCase {
    List<InscripcionDTO> findAllRechazadaOrPendiente();

    List<InscripcionDTO> findAllByEstado(String estado);
}
