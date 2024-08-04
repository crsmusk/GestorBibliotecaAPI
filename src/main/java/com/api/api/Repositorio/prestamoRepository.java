package com.api.api.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.api.Model.Entities.prestamo;
@Repository
public interface prestamoRepository extends JpaRepository<prestamo,Long>{

}
