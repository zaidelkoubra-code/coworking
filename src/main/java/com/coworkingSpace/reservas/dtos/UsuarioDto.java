package com.coworkingSpace.reservas.dtos;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioDto {
    private Long id;
    private String nombre;
    private String apellidos;
    private String numeroDeTelefono;
    private String correoElectornico;
}
