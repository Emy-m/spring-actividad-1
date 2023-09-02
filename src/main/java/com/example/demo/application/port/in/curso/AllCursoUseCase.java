package com.example.demo.application.port.in.curso;

import com.example.demo.adapter.in.api.dto.CursoDTO;

import java.time.LocalDate;
import java.util.List;

public interface AllCursoUseCase {
    List<CursoDTO> findAll();

    List<CursoDTO> findAllAfterDate(LocalDate date);
}
