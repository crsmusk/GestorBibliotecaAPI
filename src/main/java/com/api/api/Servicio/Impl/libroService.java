package com.api.api.Servicio.Impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.api.api.Excepciones.Exceptions.noHayContenidoException;
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
      List<libro>libro=libroRepo.findAll();
      if (libro.isEmpty()) {
        throw new noHayContenidoException();
      }
      return mapper.tolibrosDto(libro);
  }

   @Override
   public libroDto findById(Long id) {
     libro libro=libroRepo.findById(id).orElseThrow(()-> new libroException("libro no encontrado"+id));
     libroDto librito=mapper.toLibroDto(libro);
     return librito;
   }

   @Override
   public void save(libroDto librodDto) {
       List<genero>generos=librodDto.getNombreGenero().
               stream().map(nombreGenero-> generoRepo.findByNombreGeneroIgnoreCase(nombreGenero).orElseThrow(()->new generoException()))
               .toList();
    autor autor=autorRepo.findByNombreIgnoreCase(librodDto.getNombreAutor()).orElseThrow(()->new autorException());
    libro libro =new libro();
    libro.setTitulo(librodDto.getTitulo());
    libro.setEstado(librodDto.isEstado());
    libro.setGenero(generos);
    libro.setAutor(autor);
    libroRepo.save(libro);
   }

   @Override
   public void deleteById(Long id) {
    if (libroRepo.existsById(id)) {
       libroRepo.deleteById(id);
    }else{
      throw new libroException("no se encontro el libro con el id"+id);
    }
   }

   @Override
   public libroDto findByTitulo(String titulo) {
       Optional<libro>libroOptional=libroRepo.findByTituloIgnoreCase(titulo);
       if(libroOptional.isPresent()){
         libro Libro=libroOptional.get();
         libroDto libro=mapper.toLibroDto(Libro);
         return libro;
       }else{
        throw new libroException("no se encontro el libro");
       }
   }

   
   @Override
   public void update(Long id, libroDto libroDTO) {
     Optional<libro>libroOpional=libroRepo.findById(id);

     List<genero>generos=libroDTO.getNombreGenero()
             .stream().map(genero->generoRepo.findByNombreGeneroIgnoreCase(genero).orElseThrow(()->new generoException()))
             .toList();

     autor autor=autorRepo.findByNombreIgnoreCase(libroDTO.getNombreAutor()).orElseThrow(()->new autorException());
    if(libroOpional.isPresent()){
      libro libro=libroOpional.get();
      libro.setTitulo(libroDTO.getTitulo());
      libro.setAutor(autor);
      libro.setGenero(generos);
      libro.setEstado(libroDTO.isEstado());
      libroRepo.save(libro);
    }else{
      throw new libroException("no se encontro el libro");
    }
   }

  @Override
  public List<libroDto> BooksAvailable() {
    List<libro>libros=libroRepo.findByEstadoTrueOrderByTituloAsc();
    if (libros.isEmpty()) {
      throw new noHayContenidoException();
    }
    return mapper.tolibrosDto(libroRepo.findByEstadoTrueOrderByTituloAsc());
  }

  @Override
  public List<libroDto> BooksNotAvailable() {
    List<libro>libros=libroRepo.findByEstadoFalseOrderByTituloAsc();
    if (libros.isEmpty()) {
      throw new noHayContenidoException();
    }
    return mapper.tolibrosDto(libros);
  }

    @Override
    public List<libroDto> findByAuthor(String autor) {
      autor autor1=autorRepo.findByNombreIgnoreCase(autor).orElseThrow(()->new autorException());
      return mapper.tolibrosDto(autor1.getLibros());
    }

    @Override
    public List<libroDto> findByGender(String genero) {
       genero genero1=generoRepo.findByNombreGeneroIgnoreCase(genero).orElseThrow(()->new generoException());
       return mapper.tolibrosDto(genero1.getLibros());
    }
}
