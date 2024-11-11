package com.api.api.Servicio.Interface;
import java.util.List;


import com.api.api.Model.DTO.libroDto;
public interface Ilibro {

   public List<libroDto>findAll();

   public libroDto findById(Long id);

   public void save(libroDto librodDto);

   public void update(Long id,libroDto librodDto);

   public void deleteById(Long id);

   public libroDto findByTitulo(String titulo);

   public List<libroDto> BooksAvailable();

   public List<libroDto>BooksNotAvailable();

   public List<libroDto>findByAuthor(String autor);

   public List<libroDto>findByGender(String genero);
   
}
