package com.coworkingSpace.reservas.controllers;

import com.coworkingSpace.reservas.dtos.EspacioDto;
import com.coworkingSpace.reservas.mappers.EspacioMapper;
import com.coworkingSpace.reservas.models.Espacio;
import com.coworkingSpace.reservas.services.EspacioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/espacios")
public class EspacioController {
    @Autowired
    EspacioService espacioService;
    @Autowired
    EspacioMapper espacioMapper;

    @PostMapping
    public ResponseEntity<EspacioDto> crearEspacio(@RequestBody EspacioDto espacio) {
        espacioService.crearEspacio(espacioMapper.dtoToModel(espacio));
        return new ResponseEntity<>(espacio, HttpStatus.CREATED);
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<EspacioDto> quitarEspacio(@PathVariable Long id) {
        espacioService.quitarEspacio(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<EspacioDto>> getAllEspacios() {
        List<EspacioDto> list = espacioService.getAllEspacios()
                .stream()
                .map(espacio -> espacioMapper.modelToDto(espacio))
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EspacioDto> getEspacioById(@PathVariable Long id) {
        Optional<Espacio> optionalEspacio = espacioService.getEspacio(id);
        if (optionalEspacio.isPresent()) {
            EspacioDto dto = espacioMapper.modelToDto(optionalEspacio.get());
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
