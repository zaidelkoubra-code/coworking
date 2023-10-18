package com.coworkingSpace.reservas.repositories;

import com.coworkingSpace.reservas.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
