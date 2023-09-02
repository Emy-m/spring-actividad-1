package com.example.demo.application.service.inscripcion;

import com.example.demo.adapter.in.api.dto.InscripcionDTO;
import com.example.demo.application.port.in.inscripcion.AllInscripcionUseCase;
import com.example.demo.application.port.out.InscripcionPort;
import com.example.demo.common.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@UseCase
public class AllInscripcionService implements AllInscripcionUseCase {

    private final InscripcionPort inscripcionPort;

    @Override
    public List<InscripcionDTO> findAllRechazadaOrPendiente() {
        return inscripcionPort.findAllByEstadoIn(Arrays.asList("Aceptada", "Pendiente")).stream().map(i -> new InscripcionDTO(
                i.getId(), i.getEstado(), i.getFechaDeInscripcion(), i.getEstudiante().getId(), i.getCurso().getId()
        )).toList();
    }

    @Override
    public List<InscripcionDTO> findAllByEstado(String estado) {
        return inscripcionPort.findAllByEstadoEquals(estado).stream().map(i -> new InscripcionDTO(
                i.getId(), i.getEstado(), i.getFechaDeInscripcion(), i.getEstudiante().getId(), i.getCurso().getId()
        )).toList();
    }
}
