package com.api.api.Repositorio;

import com.api.api.Model.Entities.rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface rolRepository extends JpaRepository<rol,Long> {
    Optional<rol>findByNombreRolIgnoreCase(String nombre);
}
