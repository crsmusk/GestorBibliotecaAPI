package com.api.api.Repositorio;

import com.api.api.Model.Entities.permiso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface permisoRepository extends JpaRepository<permiso,Long> {
    Optional<permiso>findByNombrePermisoIgnoreCase(String nombre);
}
