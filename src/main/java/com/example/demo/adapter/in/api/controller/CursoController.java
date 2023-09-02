package com.example.demo.adapter.in.api.controller;

import com.example.demo.adapter.in.api.dto.CursoDTO;
import com.example.demo.application.port.in.curso.AllCursoUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/curso")
@AllArgsConstructor
public class CursoController {
    private final AllCursoUseCase allCursoUseCase;

    @GetMapping
    public List<CursoDTO> findAll() {
        return allCursoUseCase.findAll();
    }

    @GetMapping("/{date}")
    public List<CursoDTO> findAllByFechaInicioGreaterThanEqual(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return allCursoUseCase.findAllAfterDate(localDate);
    }
}
