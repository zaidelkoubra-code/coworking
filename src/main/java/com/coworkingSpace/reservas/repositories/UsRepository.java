package com.coworkingSpace.reservas.repositories;

import com.coworkingSpace.reservas.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsRepository extends JpaRepository<Usuario, Long> {

}
