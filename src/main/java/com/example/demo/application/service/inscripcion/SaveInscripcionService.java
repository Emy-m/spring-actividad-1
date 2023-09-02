package com.example.demo.application.service.inscripcion;

import com.example.demo.adapter.in.api.dto.InscripcionDTO;
import com.example.demo.adapter.out.persistence.mapper.CursoMapper;
import com.example.demo.adapter.out.persistence.mapper.EstudianteMapper;
import com.example.demo.application.port.in.inscripcion.SaveInscripcionUseCase;
import com.example.demo.application.port.out.CursoPort;
import com.example.demo.application.port.out.EstudiantePort;
import com.example.demo.application.port.out.InscripcionPort;
import com.example.demo.common.UseCase;
import com.example.demo.domain.Curso;
import com.example.demo.domain.Estudiante;
import com.example.demo.domain.Inscripcion;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
@UseCase
public class SaveInscripcionService implements SaveInscripcionUseCase {

    private final InscripcionPort inscripcionPort;
    private final EstudiantePort estudiantePort;
    private final CursoPort cursoPort;

    @Override
    public void saveInscripcion(InscripcionDTO inscripcionDTO) {
        Optional<Estudiante> estudianteOptional = estudiantePort.findById(inscripcionDTO.getEstudiante());
        Optional<Curso> cursoOptional = cursoPort.findById(inscripcionDTO.getCurso());

        if (cursoOptional.isEmpty()) {
            throw new RuntimeException("Id invalido");
        }
        if (estudianteOptional.isEmpty()) {
            throw new RuntimeException("Id invalido");
        }

        Curso curso = cursoOptional.get();
        Estudiante estudiante = estudianteOptional.get();

        // check if estudiante is mayor de edad 18 age
        if (LocalDate.now().getYear() - estudiante.getFechaNacimiento().getYear() < 18) {
            throw new RuntimeException("Estudiante no es mayor de edad");
        }

        inscripcionPort.save(
                new Inscripcion(inscripcionDTO.getId(), inscripcionDTO.getFechaInscripcion(), inscripcionDTO.getEstado(), estudiante, curso)
        );
    }
}
