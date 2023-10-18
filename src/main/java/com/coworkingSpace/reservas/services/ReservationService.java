    package com.coworkingSpace.reservas.services;

    import com.coworkingSpace.reservas.models.Espacio;
    import com.coworkingSpace.reservas.models.Reservation;
    import com.coworkingSpace.reservas.repositories.EspacioRepository;
    import com.coworkingSpace.reservas.repositories.ReservationRepository;
    import com.coworkingSpace.reservas.repositories.UsRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.kafka.core.KafkaTemplate;
    import org.springframework.messaging.simp.user.UserDestinationResolver;
    import org.springframework.stereotype.Service;

    import java.time.LocalDateTime;
    import java.util.List;
    import java.util.Optional;

    @Service
    public class ReservationService {
        @Autowired
        private ReservationRepository reservationRepository;

        @Autowired
        private EspacioRepository espacioRepository;

        @Autowired
        private UsRepository usuarioRepository;


        public List<Reservation> getAllReservaciones() {
            return reservationRepository.findAll();
        }

        public Optional<Reservation> getReservation(Long id) {
            return reservationRepository.findById(id);
        }

        public Reservation crearReservacion(Reservation reservation) {
            if(!usuarioRepository.existsById(reservation.getUsuarioId())) {
                throw new RuntimeException("Usuario no existe con ID: " + reservation.getUsuarioId());
            }

            if(!espacioRepository.existsById(reservation.getEspacioId())) {
                throw new RuntimeException("Espacio no existe con ID: " + reservation.getEspacioId());
            }

            return reservationRepository.save(reservation);

        }


        public void modificarReservacion(Long id, LocalDateTime horaDeComienzo,
                                         LocalDateTime horaDeFinalizacion,
                                         Long nuevoEspacioId) {
            Optional<Reservation> optionalReservation = reservationRepository.findById(id);

            if (optionalReservation.isPresent()) {
                Reservation existingReservation = optionalReservation.get();
                existingReservation.setHoraDeComienzo(horaDeComienzo);
                existingReservation.setHoraDeFinalizacion(horaDeFinalizacion);
                existingReservation.setEspacioId(nuevoEspacioId);

                reservationRepository.save(existingReservation);
            } else {
                throw new RuntimeException("Reservacion no encontrada con ID: " + id);
            }
        }

        public void eliminarReservacion(Long id) {
            reservationRepository.deleteById(id);
        }
    }
