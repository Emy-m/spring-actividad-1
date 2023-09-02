package com.example.demo.application.service.curso;

import com.example.demo.adapter.in.api.dto.CursoDTO;
import com.example.demo.application.port.in.curso.AllCursoUseCase;
import com.example.demo.application.port.out.CursoPort;
import com.example.demo.common.UseCase;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@UseCase
public class AllCursoService implements AllCursoUseCase {

    private final CursoPort cursoPort;

    @Override
    public List<CursoDTO> findAll() {
        return cursoPort.findAll().stream().map(c -> new CursoDTO(
                c.getId(), c.getNombre(), c.getDescripcion(), c.getFechaInicio(), c.getFechaFin()
        )).toList();
    }

    @Override
    public List<CursoDTO> findAllAfterDate(LocalDate date) {
        return cursoPort.findAllByFechaInicioGreaterThan(date).stream().map(c -> new CursoDTO(
                c.getId(), c.getNombre(), c.getDescripcion(), c.getFechaInicio(), c.getFechaFin()
        )).toList();
    }
}
