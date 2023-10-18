package com.coworkingSpace.reservas.controllers;

import com.coworkingSpace.reservas.dtos.UsuarioDto;
import com.coworkingSpace.reservas.mappers.UsuarioMapper;
import com.coworkingSpace.reservas.models.Usuario;
import com.coworkingSpace.reservas.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    UsuarioMapper usuarioMapper;

    @PostMapping
    public ResponseEntity<UsuarioDto> altaUsuario(@RequestBody UsuarioDto usuario) {
        usuarioService.altaUsuario(usuarioMapper.dtoToModel(usuario));
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioDto> bajaUsuario(@PathVariable Long id) {
        usuarioService.bajaUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/correoElectronico")
    public ResponseEntity<UsuarioDto> cambiarCorreo(@PathVariable Long id, @RequestParam String nuevoCorreo) {
        usuarioService.cambiarCorreo(id, nuevoCorreo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}/numeroDeTelefono")
    public ResponseEntity<UsuarioDto> cambiarNumeroTelefono(@PathVariable Long id, @RequestParam String nuevoNumero) {
        usuarioService.cambiarNumeroTelefono(id, nuevoNumero);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDto>> getAllUsuarios() {
        List<UsuarioDto> list = usuarioService.getAllUsuarios()
                .stream()
                .map(usuario -> usuarioMapper.modelToDto(usuario))
                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getUsuarioById(@PathVariable Long id) {
        Optional<Usuario> optionalUsuario = usuarioService.getUsuario(id);
        if (optionalUsuario.isPresent()) {
            UsuarioDto dto = usuarioMapper.modelToDto(optionalUsuario.get());
            return new ResponseEntity<>(dto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
