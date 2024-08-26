package com.api.api.Servicio.Impl;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.Excepciones.Exceptions.autorException;
import com.api.api.Excepciones.Exceptions.generoException;
import com.api.api.Excepciones.Exceptions.libroException;
import com.api.api.Model.DTO.libroDto;
import com.api.api.Model.Entities.autor;
import com.api.api.Model.Entities.genero;
import com.api.api.Model.Entities.libro;
import com.api.api.Repositorio.autorRepository;
import com.api.api.Repositorio.generoRepository;
import com.api.api.Repositorio.libroRepository;
import com.api.api.Servicio.Interface.Ilibro;
import com.api.api.mapper.libroMapper;

@Service
public class libroService implements Ilibro {
   @Autowired
   private libroRepository libroRepo;
   @Autowired
   private libroMapper mapper;
   @Autowired
   private autorRepository autorRepo;
   @Autowired
   private generoRepository generoRepo;

   @Override
   public List<libroDto> findAll() {
      List<libroDto> libroList = mapper.tolibrosDto(libroRepo.findAll());
      return libroList;
  }

   @Override
   public Optional<libroDto> findById(Long id) {
     libro libro=libroRepo.findById(id).orElseThrow(()-> new libroException("libro no encontrado"+id));
     libroDto librito=mapper.toLibroDto(libro);
     return Optional.of(librito);
   }

   @Override
   public void save(libroDto librodDto) {
    genero genero=generoRepo.findByNombreGeneroIgnoreCase(librodDto.getNombreGenero()).orElseThrow(()->new generoException());
    autor autor=autorRepo.findByNombreIgnoreCase(librodDto.getNombreAutor()).orElseThrow(()->new autorException());
    libro libro =new libro();
    libro.setTitulo(librodDto.getTitulo());
    libro.setEstado(librodDto.isEstado());
    libro.setGenero(genero);
    libro.setAutor(autor);
    libroRepo.save(libro);
   }

   @Override
   public void deleteById(Long id) {
     libroRepo.deleteById(id);
   }

   @Override
   public Optional<libroDto>findByTitulo(String titulo) {
       Optional<libro>libroOptional=libroRepo.findByTituloIgnoreCase(titulo);
       if(libroOptional.isPresent()){
         libro Libro=libroOptional.get();
         libroDto libro=mapper.toLibroDto(Libro);
         return Optional.of(libro);
       }else{
        throw new libroException("no se encontro el libro");
       }
   }

   
   @Override
   public void update(Long id, libroDto libroDTO) {
    Optional<libro>libroOpional=libroRepo.findById(id);
    genero genero=generoRepo.findByNombreGeneroIgnoreCase(libroDTO.getNombreGenero()).orElseThrow(()->new generoException());
    autor autor=autorRepo.findByNombreIgnoreCase(libroDTO.getNombreAutor()).orElseThrow(()->new autorException());

    if(libroOpional.isPresent()){
      libro libro=libroOpional.get();
      libro.setTitulo(libroDTO.getTitulo());
      libro.setAutor(autor);
      libro.setGenero(genero);
      libro.setEstado(libroDTO.isEstado());
      libroRepo.save(libro);
    }else{
      throw new libroException("no se encontro el libro");
    }
   }

  @Override
  public List<libroDto> BooksAvailable() {
    return mapper.tolibrosDto(libroRepo.findByEstadoTrueOrderByTituloAsc());
  }

  @Override
  public List<libroDto> BooksNotAvailable() {
    return mapper.tolibrosDto(libroRepo.findByEstadoFalseOrderByTituloAsc());
  }
}
