package com.api.api.Servicio.Interface;
import java.util.List;
import java.util.Optional;

import com.api.api.Model.DTO.libroDto;
public interface Ilibro {

   public List<libroDto>findAll();

   public Optional<libroDto> findById(Long id);

   public void save(libroDto librodDto);

   public void update(Long id,libroDto librodDto);

   public void deleteById(Long id);

   public Optional<libroDto> findByTitulo(String titulo);

   public List<libroDto> BooksAvailable();

   public List<libroDto>BooksNotAvailable();

   
}
