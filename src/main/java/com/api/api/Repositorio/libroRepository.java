package com.api.api.Repositorio;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.api.Model.Entities.libro;
import java.util.List;


@Repository
public interface libroRepository extends JpaRepository<libro,Long > {
   Optional<libro> findByTituloIgnoreCase(String titulo);
   List<libro>findByEstadoTrueOrderByTituloAsc();
}
