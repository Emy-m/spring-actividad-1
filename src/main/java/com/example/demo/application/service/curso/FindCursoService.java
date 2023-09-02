package com.example.demo.application.service.curso;

import com.example.demo.application.port.in.curso.FindCursoUseCase;
import com.example.demo.application.port.out.CursoPort;
import com.example.demo.common.UseCase;
import com.example.demo.domain.Curso;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@UseCase
public class FindCursoService implements FindCursoUseCase {

    private final CursoPort cursoPort;

    @Override
    public Curso findById(Long id) {
        Optional<Curso> cursoOptional = cursoPort.findById(id);

        if (cursoOptional.isEmpty()) {
            throw new RuntimeException("Id invalido");
        }

        return cursoOptional.get();
    }
}
