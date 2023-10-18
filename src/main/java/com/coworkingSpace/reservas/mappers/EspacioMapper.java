package com.coworkingSpace.reservas.mappers;

import com.coworkingSpace.reservas.models.Espacio;
import com.coworkingSpace.reservas.dtos.EspacioDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EspacioMapper {
    EspacioDto modelToDto(Espacio espacio);
    Espacio dtoToModel(EspacioDto espacio);
}
