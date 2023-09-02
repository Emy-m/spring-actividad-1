package com.example.demo.application.service.curso;

import com.example.demo.application.port.in.curso.AllCursoUseCase;
import com.example.demo.application.port.out.CursoPort;
import com.example.demo.common.UseCase;
import com.example.demo.domain.Curso;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@UseCase
public class AllCursoService implements AllCursoUseCase {

    private final CursoPort cursoPort;

    @Override
    public List<Curso> findAll() {
        return cursoPort.findAll();
    }

    @Override
    public List<Curso> findAllAfterDate(LocalDate date) {
        return cursoPort.findAllByFechaInicioGreaterThan(date);
    }
}
