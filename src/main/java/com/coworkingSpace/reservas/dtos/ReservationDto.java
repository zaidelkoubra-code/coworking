package com.coworkingSpace.reservas.dtos;

import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ReservationDto {
    private Long id;
    private Long usuarioId;
    private Long espacioId;
    private LocalDateTime horaDeComienzo;
    private LocalDateTime horaDeFinalizacion;
}
