package com.api.api.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.api.Model.Entities.persona;

import java.util.Optional;

@Repository
public interface personaRepository extends JpaRepository<persona,Long>{
  Optional<persona> findByEmail(String email);
}
