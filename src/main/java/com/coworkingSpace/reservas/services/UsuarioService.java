package com.coworkingSpace.reservas.services;

import com.coworkingSpace.reservas.FailedTransactionException;
import com.coworkingSpace.reservas.models.Reservation;
import com.coworkingSpace.reservas.models.Usuario;
import com.coworkingSpace.reservas.repositories.UsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsRepository usRepository;

    public UsuarioService(UsRepository usRepository) {
        this.usRepository = usRepository;
    }

    public List<Usuario> getAllUsuarios() { return usRepository.findAll(); }

    public Optional<Usuario> getUsuario(Long id) { return usRepository.findById(id); }

    public void altaUsuario(Usuario usuario) { usRepository.save(usuario);}

    public void bajaUsuario(Long id) { usRepository.deleteById(id); }

    @Transactional
    public void cambiarCorreo(Long id, String nuevoCorreo) {
        Usuario usuario = usRepository.findById(id).orElse(null);
        if (usuario != null) {
            usuario.setCorreoElectornico(nuevoCorreo);
            usRepository.save(usuario);
        } else {
            throw new FailedTransactionException("Usuario no existe.");
        }
    }

    @Transactional
    public void cambiarNumeroTelefono(Long id, String nuevoNumeroTelefono) {
        Usuario usuario = usRepository.findById(id).orElse(null);
        if (usuario != null) {
            usuario.setNumeroDeTelefono(nuevoNumeroTelefono);
            usRepository.save(usuario);
        } else {
            throw new FailedTransactionException("Usuario no existe.");
        }
    }

}
