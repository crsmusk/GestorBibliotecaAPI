package com.api.api.Repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.api.Model.Entities.genero;
@Repository
public interface generoRepository extends JpaRepository<genero,Long> {
   Optional<genero>findByNombreGeneroIgnoreCase(String nombre);
}
