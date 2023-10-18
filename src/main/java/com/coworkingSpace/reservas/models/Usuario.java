package com.coworkingSpace.reservas.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor

@Entity
@Table(name="usuarios")
public class Usuario {

    @Id
    @SequenceGenerator(name = "us_id_sequence", sequenceName = "us_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "us_id_sequence")
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "numeroDeTelefono")
    private String numeroDeTelefono;

    @Column(name = "correoElectronico")
    private String correoElectornico;

}
