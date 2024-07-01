package com.api.api.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.api.Entidades.Entities.persona;

import java.util.Optional;


public interface personaRepositorio extends JpaRepository<persona,Long>{
  Optional<persona> findByNombre(String nombre);
}
