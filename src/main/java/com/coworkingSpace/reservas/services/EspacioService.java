package com.coworkingSpace.reservas.services;

import com.coworkingSpace.reservas.models.Espacio;
import com.coworkingSpace.reservas.repositories.EspacioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspacioService {
    @Autowired
    EspacioRepository espacioRepository;

    public List<Espacio> getAllEspacios() { return espacioRepository.findAll(); }

    public Optional<Espacio> getEspacio(Long id) { return espacioRepository.findById(id); }

    public void crearEspacio(Espacio espacio) { espacioRepository.save(espacio); }

    public void quitarEspacio(Long id) { espacioRepository.deleteById(id); }


}
