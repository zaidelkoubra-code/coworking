        package com.coworkingSpace.reservas.mappers;

        import com.coworkingSpace.reservas.models.Reservation;
        import com.coworkingSpace.reservas.dtos.ReservationDto;
        import org.mapstruct.Mapper;
        import org.mapstruct.Mapping;

        @Mapper(componentModel = "spring")
        public interface ReservationMapper {

            ReservationDto modelToDto(Reservation reservation);

            Reservation dtoToModel(ReservationDto reservationDto);

        }
