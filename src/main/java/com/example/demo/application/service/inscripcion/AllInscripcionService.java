package com.example.demo.application.service.inscripcion;

import com.example.demo.application.port.in.inscripcion.AllInscripcionUseCase;
import com.example.demo.application.port.out.InscripcionPort;
import com.example.demo.common.UseCase;
import com.example.demo.domain.Inscripcion;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@UseCase
public class AllInscripcionService implements AllInscripcionUseCase {

    private final InscripcionPort inscripcionPort;

    @Override
    public List<Inscripcion> findAllRechazadaOrPendiente() {
        return inscripcionPort.findAllByEstadoIn(Arrays.asList("Aceptada", "Pendiente"));
    }

    @Override
    public List<Inscripcion> findAllByEstado(String estado) {
        return inscripcionPort.findAllByEstadoEquals(estado);
    }
}
