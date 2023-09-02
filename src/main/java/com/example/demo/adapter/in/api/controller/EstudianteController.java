package com.example.demo.adapter.in.api.controller;

import com.example.demo.adapter.in.api.dto.EstudianteDTO;
import com.example.demo.application.port.in.estudiante.AllEstudianteUseCase;
import com.example.demo.application.port.in.estudiante.SaveEstudianteUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
@AllArgsConstructor
public class EstudianteController {
    private final AllEstudianteUseCase allEstudianteUseCase;
    private final SaveEstudianteUseCase saveEstudianteUseCase;

    @GetMapping
    public List<EstudianteDTO> findAll() {
        return allEstudianteUseCase.findAll();
    }

    @GetMapping("/romero")
    public List<EstudianteDTO> findAllByDniGreaterThanAndApellidoEqualsRomero() {
        return allEstudianteUseCase.findAllByDniGreaterThanAndApellidoEqualsRomero();
    }

    @GetMapping("/asc/{page}/{size}")
    public List<EstudianteDTO> findAllPaginatedAndSorted(@PathVariable int page, @PathVariable int size) {
        return allEstudianteUseCase.findAll(page, size);
    }

    @PostMapping
    public void save(@RequestBody EstudianteDTO estudianteDTO) {
        saveEstudianteUseCase.save(estudianteDTO);
    }
}
