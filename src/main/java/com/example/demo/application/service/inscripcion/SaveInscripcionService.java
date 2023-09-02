package com.example.demo.application.service.inscripcion;

import com.example.demo.application.port.in.inscripcion.SaveInscripcionUseCase;
import com.example.demo.application.port.out.InscripcionPort;
import com.example.demo.common.UseCase;

import com.example.demo.domain.Inscripcion;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
@UseCase
public class SaveInscripcionService implements SaveInscripcionUseCase {

    private final InscripcionPort inscripcionPort;

    @Override
    public void save(Inscripcion inscripcion) {
        int actualYear = LocalDate.now().getYear();
        int birthYear = inscripcion.getEstudiante().getFechaNacimiento().getYear();

        if (actualYear - birthYear < 18) {
            throw new RuntimeException("Estudiante no es mayor de edad");
        }

        inscripcionPort.save(inscripcion);
    }
}
