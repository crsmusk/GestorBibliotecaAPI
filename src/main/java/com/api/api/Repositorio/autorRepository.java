package com.api.api.Repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.api.Model.Entities.autor;
@Repository
public interface autorRepository extends JpaRepository<autor,Long> {
   Optional<autor>findByNombreIgnoreCase(String nombre);
}
