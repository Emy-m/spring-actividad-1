package com.example.demo.adapter.in.api.controller;

import com.example.demo.adapter.in.api.dto.InscripcionDTO;
import com.example.demo.application.port.in.curso.FindCursoUseCase;
import com.example.demo.application.port.in.estudiante.FindEstudianteUseCase;
import com.example.demo.application.port.in.inscripcion.AllInscripcionUseCase;
import com.example.demo.application.port.in.inscripcion.SaveInscripcionUseCase;
import com.example.demo.domain.Curso;
import com.example.demo.domain.Estudiante;
import com.example.demo.domain.Inscripcion;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscripcion")
@AllArgsConstructor
public class InscripcionController {
    private final SaveInscripcionUseCase saveInscripcionUseCase;
    private final AllInscripcionUseCase allInscripcionUseCase;
    private final FindEstudianteUseCase findEstudianteUseCase;
    private final FindCursoUseCase findCursoUseCase;

    @GetMapping
    public List<InscripcionDTO> findAllRechazadaOrPendiente() {
        return allInscripcionUseCase.findAllRechazadaOrPendiente().stream().map(
                i -> new InscripcionDTO(i.getId(), i.getEstado(), i.getFechaDeInscripcion(), i.getEstudiante().getId(), i.getCurso().getId())
        ).toList();
    }

    @GetMapping("{state}")
    public List<InscripcionDTO> findAll(@PathVariable String state) {
        return allInscripcionUseCase.findAllByEstado(state).stream().map(
                i -> new InscripcionDTO(i.getId(), i.getEstado(), i.getFechaDeInscripcion(), i.getEstudiante().getId(), i.getCurso().getId())
        ).toList();
    }

    @PostMapping
    public void save(@RequestBody InscripcionDTO inscripcionDTO) {
        Estudiante estudiante = findEstudianteUseCase.findById(inscripcionDTO.getEstudiante());
        Curso curso = findCursoUseCase.findById(inscripcionDTO.getCurso());

        saveInscripcionUseCase.save(
                new Inscripcion(inscripcionDTO.getId(), inscripcionDTO.getFechaInscripcion(), inscripcionDTO.getEstado(), estudiante, curso)
        );
    }
}
