package com.coworkingSpace.reservas.mappers;

import com.coworkingSpace.reservas.models.Usuario;
import com.coworkingSpace.reservas.dtos.UsuarioDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    UsuarioDto modelToDto(Usuario usuario);
    Usuario dtoToModel(UsuarioDto user);
}
