package com.example.demo.adapter.in.api.controller;

import com.example.demo.adapter.in.api.dto.InscripcionDTO;
import com.example.demo.application.port.in.inscripcion.AllInscripcionUseCase;
import com.example.demo.application.port.in.inscripcion.SaveInscripcionUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscripcion")
@AllArgsConstructor
public class InscripcionController {
    private final SaveInscripcionUseCase saveInscripcionUseCase;
    private final AllInscripcionUseCase allInscripcionUseCase;

    @GetMapping
    public List<InscripcionDTO> findAllRechazadaOrPendiente() {
        return allInscripcionUseCase.findAllRechazadaOrPendiente();
    }

    @GetMapping("{state}")
    public List<InscripcionDTO> findAll(@PathVariable String state) {
        return allInscripcionUseCase.findAllByEstado(state);
    }

    @PostMapping
    public void save(@RequestBody InscripcionDTO inscripcionDTO) {
        saveInscripcionUseCase.saveInscripcion(inscripcionDTO);
    }
}
