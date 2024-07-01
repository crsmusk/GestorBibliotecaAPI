package com.api.api.Servicio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.Entidades.DTO.libroDTO;
import com.api.api.Entidades.Entities.libro;
import com.api.api.Excepciones.libroException;
import com.api.api.Repositorio.libroRepositorio;

@Service
public class libroService {
   @Autowired
   private libroRepositorio libroRepo;

   public List<libro> getLibros(){
    return libroRepo.findAll();
   }

   public libro getLibro(Long id){
    return libroRepo.findById(id).orElseThrow(()-> new libroException("libro no encontrado con el id "));
   }

   public libro createLibro(libroDTO libroDTO){
    libro libro=new libro();
    libro.setTitulo(libroDTO.getTitulo());
    libro.setAutor(libroDTO.getAutor());
    libro.setGenero(libroDTO.getGenero());
    libro.setEstado(libroDTO.isEstado());
    return libroRepo.save(libro);
   }

   public libro updateLibro(Long id,libroDTO libroDTO){
    libro libro=libroRepo.findById(id).orElseThrow(()-> new libroException("libro no encontrado con el id "+id));
    libro.setTitulo(libroDTO.getTitulo());
    libro.setAutor(libroDTO.getAutor());
    libro.setGenero(libroDTO.getGenero());
    libro.setEstado(libroDTO.isEstado());
    return libroRepo.save(libro);

   }

   public void deleteLibro(Long id){
    libro libro=libroRepo.findById(id).orElseThrow(()-> new libroException("libro no encontrado con el id "+id));
    libroRepo.delete(libro);
   }

   public libro searchTitulo(String titulo){
    return libroRepo.findByTitulo(titulo).orElseThrow(()-> new libroException("libro no encontrado con el titulo "+titulo)); 
   }

   public List<libro> searchAutor(String autor){
    List<libro>lista=libroRepo.findAll();
    List<Long>ids=new ArrayList<>();
    for (libro libro:lista) {
        if(libro.getAutor().equals(autor)){
            ids.add(libro.getId());
        }
    }
    if(ids.isEmpty()){
        throw new libroException("no se encontro ningun libro con el autor "+autor);
    }
    return libroRepo.findAllById(ids);
   }

   public List<libro> searchGenero(String genero){
    List<libro>lista=libroRepo.findAll();
    List<Long>ids=new ArrayList<>();
    for (libro libro:lista) {
        if(libro.getGenero().equals(genero)){
            ids.add(libro.getId());
        }
    }
    if(ids.isEmpty()){
        throw new libroException("no econtro ningun libro con genero de "+genero);
    }
    return libroRepo.findAllById(ids);
   }
   
  
}
