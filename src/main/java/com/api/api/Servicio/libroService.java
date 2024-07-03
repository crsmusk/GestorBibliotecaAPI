package com.api.api.Servicio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.api.Entidades.DTO.libroDTO;
import com.api.api.Entidades.Entities.libro;
import com.api.api.Excepciones.libroException;
import com.api.api.Repositorio.libroRepositorio;
import com.api.api.persistencia.IlibroDAO;

@Service
public class libroService implements IlibroDAO {
   @Autowired
   private libroRepositorio libroRepo;

   @Override
   public List<libroDTO> findAll() {
       List<libroDTO> libroList = libroRepo.findAll().stream().map(libro->libroDTO.builder()
      .autor(libro.getAutor())
      .titulo(libro.getTitulo())
      .genero(libro.getGenero())
      .estado(libro.isEstado())
      .build()).toList();
       
      return libroList;
  }

   @Override
   public Optional<libroDTO> findById(Long id) {
     libro libro=libroRepo.findById(id).orElseThrow(()-> new libroException("libro no encontrado"+id));
     libroDTO librito=libroDTO.builder()
     .autor(libro.getAutor())
     .titulo(libro.getTitulo())
     .genero(libro.getGenero())
     .estado(libro.isEstado())
     .build();
     return Optional.of(librito);
   }

   @Override
   public void save(libroDTO librodDto) {
      libro libro=new libro();
      libro.setAutor(librodDto.getAutor());
      libro.setTitulo(librodDto.getTitulo());
      libro.setGenero(librodDto.getGenero());
      libro.setEstado(librodDto.isEstado());
      libroRepo.save(libro);
   }

   @Override
   public void deleteById(Long id) {
     libroRepo.deleteById(id);
   }

   @Override
   public Optional<libroDTO>findByTitulo(String titulo) {
       Optional<libro>libroOptional=libroRepo.findByTitulo(titulo);
       if(libroOptional.isPresent()){
         libro Libro=libroOptional.get();
         libroDTO libro=libroDTO.builder()
         .autor(Libro.getAutor())
         .titulo(Libro.getTitulo())
         .genero(Libro.getGenero())
         .estado(Libro.isEstado())
         .build();
         return Optional.of(libro);
       }
         throw new libroException("no se encontro el libro");

       
       
   }

   @Override
   public List<libroDTO> findByAutor(String autor) {
      List<libro>lista=libroRepo.findAll();
      List<Long>ids=new ArrayList<>();
      for (libro libro:lista) {
          if(libro.getAutor().equals(autor)){
              ids.add(libro.getId());
          }
      }
      List<libroDTO> libroList = libroRepo.findAllById(ids).stream().map(libro->libroDTO.builder()
      .autor(libro.getAutor())
      .titulo(libro.getTitulo())
      .genero(libro.getGenero())
      .estado(libro.isEstado())
      .build()).toList();
      
      return libroList;
   }

   @Override
   public List<libroDTO> findByGenero(String genero) {
      List<libro>lista=libroRepo.findAll();
      List<Long>ids=new ArrayList<>();
      for (libro libro:lista) {
          if(libro.getGenero().equals(genero)){
              ids.add(libro.getId());
          }
      }
      List<libroDTO> libroList = libroRepo.findAllById(ids).stream().map(libro->libroDTO.builder()
      .autor(libro.getAutor())
      .titulo(libro.getTitulo())
      .genero(libro.getGenero())
      .estado(libro.isEstado())
      .build()).toList();
      
      return libroList;
   }

   @Override
   public void update(Long id, libroDTO libroDTO) {
    Optional<libro>libroOpional=libroRepo.findById(id);
    if(libroOpional.isPresent()){
      libro libro=libroOpional.get();
      libro.setTitulo(libroDTO.getTitulo());
      libro.setAutor(libroDTO.getAutor());
      libro.setGenero(libroDTO.getGenero());
      libro.setEstado(libroDTO.isEstado());
      libroRepo.save(libro);
    }
    throw new libroException("no se encontro el libro");
   }

  
}
