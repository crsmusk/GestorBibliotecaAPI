package com.api.api.Servicio.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.api.Excepciones.Exceptions.libroException;
import com.api.api.Excepciones.Exceptions.libroNoDisponibleException;
import com.api.api.Excepciones.Exceptions.personaException;
import com.api.api.Excepciones.Exceptions.prestamoException;
import com.api.api.Model.DTO.prestamoDto;
import com.api.api.Model.Entities.libro;
import com.api.api.Model.Entities.persona;
import com.api.api.Model.Entities.prestamo;
import com.api.api.Repositorio.libroRepository;
import com.api.api.Repositorio.personaRepository;
import com.api.api.Repositorio.prestamoRepository;
import com.api.api.Servicio.Interface.Iprestamo;
import com.api.api.mapper.prestamoMapper;

@Service
public class prestamoService implements Iprestamo {
 @Autowired
 private prestamoRepository prestamoRepo;
 @Autowired
 private libroRepository libroRepo;
 @Autowired 
 private personaRepository personaRepo;
 @Autowired
 private prestamoMapper mapper;
 
 
 @Override
 @Transactional(readOnly = true)
public List<prestamoDto> findAll() {
  List<prestamoDto>lista=mapper.toprestamosDto(prestamoRepo.findAll());
  return lista;
}

@Override
@Transactional(readOnly = true)
public Optional<prestamoDto> findById(Long id) {
  prestamo presta=prestamoRepo.findById(id).orElseThrow(()-> new prestamoException("no se encontro el prestamo"));
  prestamoDto prestamo=mapper.toPrestamoDto(presta);
  return Optional.of(prestamo);

}

@Override
@Transactional
public void save(prestamoDto prestamoDTO) {
   persona persona=personaRepo.findByEmail(prestamoDTO.getPersonaDto().getEmail()).orElseThrow(()->new personaException("no se encontro al usuario"));
   libro libro=libroRepo.findByTituloIgnoreCase(prestamoDTO.getLibroDto().getTitulo()).orElseThrow(()->new libroException("no se encontro el libro"));
   if(libro.isEstado()==false){
     throw new libroNoDisponibleException("libro no disponible");
   }
   libro.setEstado(false);
   prestamo prestamo=new prestamo();
   prestamo.setLibro(libro);
   prestamo.setPersona(persona);
   prestamo.setFechaDePrestamo(prestamoDTO.getFechaDePrestamo());
   prestamo.setFechaDeEntrega(prestamoDTO.getFechaDeEntrega());
   prestamoRepo.save(prestamo);
   
}

@Override
@Transactional
public void delete(Long id) {
  prestamoRepo.deleteById(id);
}

@Override
@Transactional
public void update(Long id, prestamoDto prestamoDTO) {
   prestamo prestamo=prestamoRepo.findById(id).orElseThrow(()-> new prestamoException("no se econtro el prestamo con el id "+id));
    persona persona=personaRepo.findByEmail(prestamoDTO.getPersonaDto().getEmail()).orElseThrow(()->new personaException("no se encontro al usuario con el correo"+prestamoDTO.getPersonaDto().getEmail()));
    libro libro=libroRepo.findByTituloIgnoreCase(prestamoDTO.getLibroDto().getTitulo()).orElseThrow(()->new libroException("no se econtro el libro con el titulo"+prestamoDTO.getLibroDto().getTitulo()));
    
    libro.setEstado(false);
    prestamo.setLibro(libro);
    prestamo.setPersona(persona);
    prestamo.setFechaDePrestamo(prestamoDTO.getFechaDePrestamo());
    prestamo.setFechaDeEntrega(prestamoDTO.getFechaDeEntrega());
    prestamoRepo.save(prestamo);
}




}
