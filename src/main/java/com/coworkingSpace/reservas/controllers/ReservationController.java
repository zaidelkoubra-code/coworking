package com.coworkingSpace.reservas.controllers;

import com.coworkingSpace.reservas.dtos.ReservationDto;
import com.coworkingSpace.reservas.mappers.ReservationMapper;
import com.coworkingSpace.reservas.models.Reservation;
import com.coworkingSpace.reservas.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import java.time.LocalDateTime;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/reservaciones")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ReservationMapper reservationMapper;


    @GetMapping
    public ResponseEntity<List<ReservationDto>> getAllReservaciones() {
        List<ReservationDto> reservaciones = reservationService.getAllReservaciones()
                .stream()
                .map(reservationMapper::modelToDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(reservaciones, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDto> getReservationById(@PathVariable Long id) {
        Optional<Reservation> reservation = reservationService.getReservation(id);

        if (reservation.isPresent()) {
            ReservationDto dto = reservationMapper.modelToDto(reservation.get());
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<ReservationDto> crearReservacion(@RequestBody ReservationDto reservationDto) {
        Reservation reservation = reservationService.crearReservacion(reservationMapper.dtoToModel(reservationDto));
        return new ResponseEntity<>(reservationMapper.modelToDto(reservation), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> modificarReservacion(@PathVariable Long id,
                                                     @RequestParam LocalDateTime horaDeComienzo,
                                                     @RequestParam LocalDateTime horaDeFinalizacion,
                                                     @RequestBody Long nuevoEspacioId) {
        reservationService.modificarReservacion(id, horaDeComienzo, horaDeFinalizacion, nuevoEspacioId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReservacion(@PathVariable Long id) {
        reservationService.eliminarReservacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
