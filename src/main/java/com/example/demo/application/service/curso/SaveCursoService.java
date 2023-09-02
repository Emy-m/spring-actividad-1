package com.example.demo.application.service.curso;

import com.example.demo.application.port.in.curso.SaveCursoUseCase;
import com.example.demo.application.port.out.CursoPort;
import com.example.demo.common.UseCase;
import com.example.demo.domain.Curso;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class SaveCursoService implements SaveCursoUseCase {

    private final CursoPort cursoPort;

    @Override
    public void save(Curso curso) {
        cursoPort.save(curso);
    }
}
