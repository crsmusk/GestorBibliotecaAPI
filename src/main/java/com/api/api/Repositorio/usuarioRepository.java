package com.api.api.Repositorio;

import com.api.api.Model.Entities.usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface usuarioRepository extends JpaRepository<usuario,Long> {
    Optional<usuario>findByUserNameIgnoreCase(String nombre);
}
