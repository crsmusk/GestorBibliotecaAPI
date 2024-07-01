package com.api.api.Servicio;

import java.util.List;
import com.api.api.Entidades.Entities.persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.api.Entidades.Entities.libro;
import com.api.api.Entidades.DTO.prestamoDTO;
import com.api.api.Entidades.Entities.prestamo;
import com.api.api.Excepciones.libroNoDisponibleException;
import com.api.api.Excepciones.prestamoException;
import com.api.api.Repositorio.prestamoRepositorio;

@Service
public class prestamoService {
 @Autowired
 private prestamoRepositorio prestamoRepo;
 @Autowired
 private libroService libroService;
 @Autowired
 private personaService personaService;

 public List<prestamo> getPrestamos(){
  return prestamoRepo.findAll();
 }

 public prestamo getPrestamo(Long id){
    return prestamoRepo.findById(id).orElseThrow(()-> new prestamoException("no se encontro el prestamo con el id "+id));
 }

 public prestamo createPrestamo(prestamoDTO prestamoDTO){
    persona persona=personaService.getPersona(prestamoDTO.getIdPersona());
    libro libro=libroService.getLibro(prestamoDTO.getIdLibro());
    if(libro.isEstado()==false){
      throw new libroNoDisponibleException("libro no disponible");
    }
    libro.setEstado(false);
    prestamo prestamo=new prestamo();
    prestamo.setLibro(libro);
    prestamo.setPersona(persona);
    return prestamoRepo.save(prestamo);
 }

 public prestamo updatePrestamo(Long id,prestamoDTO prestamoDTO){
    prestamo prestamo=prestamoRepo.findById(id).orElseThrow(()-> new prestamoException("no se econtro el prestamo con el id "+id));
    persona persona=personaService.getPersona(prestamoDTO.getIdPersona());
    libro libro=libroService.getLibro(prestamoDTO.getIdLibro());
    if(libro.isEstado()==false){
      throw new libroNoDisponibleException("libro no disponible");
    }
    libro.setEstado(false);
    prestamo.setLibro(libro);
    prestamo.setPersona(persona);
    return prestamoRepo.save(prestamo);
 }

 public void deletePrestamo(Long id){
    prestamo prestamo=prestamoRepo.findById(id).orElseThrow(()-> new prestamoException("no se econtro el prestamo con el id "+id));
    prestamoRepo.delete(prestamo);
 }
 


}
