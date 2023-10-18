package com.coworkingSpace.reservas.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor

@Entity
@Table(name="reservations")
public class Reservation {
    @Id
    @SequenceGenerator(name = "res_id_sequence", sequenceName = "res_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "res_id_sequence")
    @Column(name = "id")
    private Long id;


    @Column(name = "usuarioId")
    private Long usuarioId;

    @Column(name = "espacioId")
    private Long espacioId;

    @Column(name = "horaDeComienzo")
    private LocalDateTime horaDeComienzo;

    @Column(name = "horaDeFinalizacion")
    private LocalDateTime horaDeFinalizacion;

}
