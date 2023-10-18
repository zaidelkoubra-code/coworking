package com.coworkingSpace.reservas.dtos;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EspacioDto {

    private Long id;
    private String categoria;
    private int capacidad;
    private Double tarifaPorHora;
    private Double tarifaPorDia;
}
