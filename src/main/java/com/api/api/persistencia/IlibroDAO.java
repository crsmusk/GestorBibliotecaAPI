package com.api.api.persistencia;
import com.api.api.Entidades.DTO.libroDTO;


import java.util.List;
import java.util.Optional;
public interface IlibroDAO {

   public List<libroDTO>findAll();

   public Optional<libroDTO> findById(Long id);

   public void save(libroDTO librodDto);

   public void update(Long id,libroDTO librodDto);

   public void deleteById(Long id);

   public Optional<?> findByTitulo(String titulo);

   List<libroDTO>findByAutor(String autor);

   List<libroDTO>findByGenero(String genero);

}
