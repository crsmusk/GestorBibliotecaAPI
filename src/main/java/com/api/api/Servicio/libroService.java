package com.api.api.Servicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.Excepciones.Exceptions.libroException;
import com.api.api.Model.DTO.libroDto;
import com.api.api.Model.Entities.libro;
import com.api.api.Repositorio.libroRepository;
import com.api.api.mapper.libroMapper;
import com.api.api.persistencia.IlibroDAO;

@Service
public class libroService implements IlibroDAO {
   @Autowired
   private libroRepository libroRepo;
   @Autowired
   private libroMapper mapper;

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
    libroRepo.save(mapper.libro(librodDto));
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
    if(libroOpional.isPresent()){
      libro libro=libroOpional.get();
      libro.setTitulo(libroDTO.getTitulo());
      libro.setAutor(libroDTO.getAutor());
      libro.setGenero(libroDTO.getGenero());
      libro.setEstado(libroDTO.isEstado());
      libroRepo.save(libro);
    }else{
      throw new libroException("no se encontro el libro");
    }
   }
}
