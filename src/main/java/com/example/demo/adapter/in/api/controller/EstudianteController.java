package com.example.demo.adapter.in.api.controller;

import com.example.demo.adapter.in.api.dto.EstudianteDTO;
import com.example.demo.application.port.in.estudiante.*;
import com.example.demo.domain.Estudiante;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiante")
@AllArgsConstructor
public class EstudianteController {
    private final AllEstudianteUseCase allEstudianteUseCase;
    private final FindEstudianteUseCase findEstudianteUseCase;
    private final SaveEstudianteUseCase saveEstudianteUseCase;
    private final UpdateEstudianteUseCase updateEstudianteUseCase;
    private final DeleteEstudianteUseCase deleteEstudianteUseCase;

    @GetMapping
    public List<EstudianteDTO> findAll() {
        return allEstudianteUseCase.findAll().stream().map(
                e -> new EstudianteDTO(e.getId(), e.getNombre(), e.getApellido(), e.getEmail(), e.getDNI(), e.getFechaNacimiento())
        ).toList();
    }

    @GetMapping("/romero")
    public List<EstudianteDTO> findAllByDniGreaterThanAndApellidoEqualsRomero() {
        return allEstudianteUseCase.findAllByDniGreaterThanAndApellidoEqualsRomero().stream().map(
                e -> new EstudianteDTO(e.getId(), e.getNombre(), e.getApellido(), e.getEmail(), e.getDNI(), e.getFechaNacimiento())
        ).toList();
    }

    @GetMapping("/{id}")
    public EstudianteDTO findById(@PathVariable Long id) {
        Estudiante estudiante = findEstudianteUseCase.findById(id);
        return new EstudianteDTO(estudiante.getId(), estudiante.getNombre(), estudiante.getApellido(), estudiante.getEmail(), estudiante.getDNI(), estudiante.getFechaNacimiento());
    }

    @GetMapping("/asc/{page}/{size}")
    public List<EstudianteDTO> findAllPaginatedAndSorted(@PathVariable int page, @PathVariable int size) {
        return allEstudianteUseCase.findAll(page, size).stream().map(
                e -> new EstudianteDTO(e.getId(), e.getNombre(), e.getApellido(), e.getEmail(), e.getDNI(), e.getFechaNacimiento())
        ).toList();
    }

    @PostMapping
    public void save(@RequestBody EstudianteDTO estudianteDTO) {
        saveEstudianteUseCase.save(
                new Estudiante(estudianteDTO.getId(), estudianteDTO.getNombre(), estudianteDTO.getApellido(), estudianteDTO.getEmail(), estudianteDTO.getDNI(), estudianteDTO.getFechaNacimiento())
        );
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody EstudianteDTO estudianteDTO) {
        updateEstudianteUseCase.update(id,
                new Estudiante(estudianteDTO.getId(), estudianteDTO.getNombre(), estudianteDTO.getApellido(), estudianteDTO.getEmail(), estudianteDTO.getDNI(), estudianteDTO.getFechaNacimiento())
        );
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deleteEstudianteUseCase.delete(id);
    }
}
