package com.api.api.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.api.Model.Entities.cliente;

import java.util.Optional;

@Repository
public interface clienteRepository extends JpaRepository<cliente,Long>{
  Optional<cliente> findByEmail(String email);
}
