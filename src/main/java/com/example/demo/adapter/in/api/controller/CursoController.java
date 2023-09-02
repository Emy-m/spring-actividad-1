package com.example.demo.adapter.in.api.controller;

import com.example.demo.adapter.in.api.dto.CursoDTO;
import com.example.demo.application.port.in.curso.AllCursoUseCase;
import com.example.demo.application.port.in.curso.SaveCursoUseCase;
import com.example.demo.domain.Curso;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/curso")
@AllArgsConstructor
public class CursoController {
    private final AllCursoUseCase allCursoUseCase;
    private final SaveCursoUseCase saveCursoUseCase;

    @GetMapping
    public List<CursoDTO> findAll() {
        return allCursoUseCase.findAll().stream().map(
                c -> new CursoDTO(c.getId(), c.getNombre(), c.getDescripcion(), c.getFechaInicio(), c.getFechaFin())
        ).toList();
    }

    @GetMapping("/{date}")
    public List<CursoDTO> findAllByFechaInicioGreaterThanEqual(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date);
        return allCursoUseCase.findAllAfterDate(localDate).stream().map(
                c -> new CursoDTO(c.getId(), c.getNombre(), c.getDescripcion(), c.getFechaInicio(), c.getFechaFin())
        ).toList();
    }

    @PostMapping
    public void save(@RequestBody CursoDTO cursoDTO) {
        saveCursoUseCase.save(
                new Curso(cursoDTO.getId(), cursoDTO.getNombre(), cursoDTO.getDescripcion(), cursoDTO.getFechaInicio(), cursoDTO.getFechaFin())
        );
    }
}
