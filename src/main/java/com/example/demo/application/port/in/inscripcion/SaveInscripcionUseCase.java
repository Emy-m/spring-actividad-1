package com.example.demo.application.port.in.inscripcion;

import com.example.demo.adapter.in.api.dto.InscripcionDTO;

public interface SaveInscripcionUseCase {
    void saveInscripcion(InscripcionDTO inscripcionDTO);
}
