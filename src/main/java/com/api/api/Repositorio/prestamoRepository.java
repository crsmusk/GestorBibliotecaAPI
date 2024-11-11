package com.api.api.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.api.Model.Entities.prestamo;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface prestamoRepository extends JpaRepository<prestamo,Long>{
    List<prestamo>findByFechaDeEntregaLessThan(LocalDate fecha);
    List<prestamo> findByEstadoPrestamoFalse();
}
