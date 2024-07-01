package com.api.api.Repositorio;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.api.api.Entidades.Entities.libro;
import java.util.List;


public interface libroRepositorio extends JpaRepository<libro,Long > {
   Optional<libro> findByTitulo(String titulo);
   List<libro>findByAutor(String autor);
   List<libro> findByGenero(String genero);
}
