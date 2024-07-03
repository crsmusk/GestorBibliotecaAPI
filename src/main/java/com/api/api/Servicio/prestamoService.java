package com.api.api.Servicio;

import java.util.List;
import java.util.Optional;

import com.api.api.Entidades.Entities.persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.api.Entidades.Entities.libro;
import com.api.api.Entidades.DTO.prestamoDTO;
import com.api.api.Entidades.Entities.prestamo;
import com.api.api.Excepciones.libroException;
import com.api.api.Excepciones.libroNoDisponibleException;
import com.api.api.Excepciones.personaException;
import com.api.api.Excepciones.prestamoException;
import com.api.api.Repositorio.libroRepositorio;
import com.api.api.Repositorio.personaRepositorio;
import com.api.api.Repositorio.prestamoRepositorio;
import com.api.api.persistencia.IprestamoDAO;

@Service
public class prestamoService implements IprestamoDAO {
 @Autowired
 private prestamoRepositorio prestamoRepo;
 @Autowired
 private libroRepositorio libroRepo;
 @Autowired 
 private personaRepositorio personaRepo;
@Override
public List<prestamoDTO> findAll() {
  List<prestamoDTO>lista=prestamoRepo.findAll().stream().map(prestamo->prestamoDTO.builder()
  .idLibro(prestamo.getLibro().getId())
  .idPersona(prestamo.getPersona().getId()).build()).toList();
  return lista;
}
@Override
public Optional<prestamoDTO> findById(Long id) {
  prestamo presta=prestamoRepo.findById(id).orElseThrow(()-> new prestamoException("no se encontro el prestamo"));
  prestamoDTO prestamo=prestamoDTO.builder()
  .idLibro(presta.getLibro().getId())
  .idPersona(presta.getPersona().getId()).build();
  return Optional.of(prestamo);

}
@Override
public void save(prestamoDTO prestamoDTO) {
   persona persona=personaRepo.findById(prestamoDTO.getIdPersona()).orElseThrow(()-> new personaException("no se encontro ala persona"));
   libro libro=libroRepo.findById(prestamoDTO.getIdLibro()).orElseThrow(()-> new libroException("no se encontro el libro"));
   if(libro.isEstado()==false){
     throw new libroNoDisponibleException("libro no disponible");
   }
   libro.setEstado(false);
   prestamo prestamo=new prestamo();
   prestamo.setLibro(libro);
   prestamo.setPersona(persona);
   prestamoRepo.save(prestamo);
   
}
@Override
public void delete(Long id) {
  prestamo prestamo=prestamoRepo.findById(id).orElseThrow(()-> new prestamoException("no se encontro el prestamo"));
  prestamoRepo.save(prestamo);
}
@Override
public void update(Long id, prestamoDTO prestamoDTO) {
   prestamo prestamo=prestamoRepo.findById(id).orElseThrow(()-> new prestamoException("no se econtro el prestamo con el id "+id));
    persona persona=personaRepo.findById(prestamoDTO.getIdPersona()).orElseThrow(()-> new personaException("no se econtro ala persona"));
    libro libro=libroRepo.findById(prestamoDTO.getIdLibro()).orElseThrow(()-> new libroException("no se encontro el libro"));
    if(libro.isEstado()==false){
      throw new libroNoDisponibleException("libro no disponible");
    }
    libro.setEstado(false);
    prestamo.setLibro(libro);
    prestamo.setPersona(persona);
     prestamoRepo.save(prestamo);
}




}
