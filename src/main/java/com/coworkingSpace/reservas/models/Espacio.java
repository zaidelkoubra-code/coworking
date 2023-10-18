package com.coworkingSpace.reservas.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="espacios")
public class Espacio {

    @Id
    @SequenceGenerator(name = "es_id_sequence", sequenceName = "es_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "es_id_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "capacidad")
    private Long capacidad;

    @Column(name = "tarifaPorHora")
    private Double tarifaPorHora;

    @Column(name = "tarifaPorDia")
    private Double tarifaPorDia;

}
