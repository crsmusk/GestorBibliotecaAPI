package com.api.api.Servicio.Impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.api.api.Excepciones.Exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.api.Model.DTO.prestamoDto;
import com.api.api.Model.Entities.libro;
import com.api.api.Model.Entities.cliente;
import com.api.api.Model.Entities.prestamo;
import com.api.api.Repositorio.libroRepository;
import com.api.api.Repositorio.clienteRepository;
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
 private clienteRepository personaRepo;
 @Autowired
 private prestamoMapper mapper;
 
 
 @Override
 @Transactional(readOnly = true)
public List<prestamoDto> findAll() {
  List<prestamo>prestamos=prestamoRepo.findAll();
  if (prestamos.isEmpty()) {
    throw new noHayContenidoException();
  }else{
    return mapper.toprestamosDto(prestamos);
  }  
}

@Override
@Transactional(readOnly = true)
public prestamoDto findById(Long id) {
  Optional<prestamo>prestamo=prestamoRepo.findById(id);
  if (prestamo.isPresent()) {
  return mapper.toPrestamoDto(prestamo.get());
  }else{
    throw new prestamoException("no se encontro el prestamo con el id "+id);
  }
}

@Override
@Transactional
public void save(prestamoDto prestamoDTO) {
   prestamo prestamo=new prestamo();
   Optional<cliente>cliente=personaRepo.findByEmail(prestamoDTO.getEmailCliente());
   List<libro>libros=new ArrayList<>();
   for (String i:prestamoDTO.getNombreLibro()){
       if (libroRepo.findByTituloIgnoreCase(i).isPresent()){
           if (libroRepo.findByTituloIgnoreCase(i).get().isEstado()){
               libros.add(libroRepo.findByTituloIgnoreCase(i).get());
           }else{
               throw new libroNoDisponibleException("el libro "+i+" no esta disponible");
           }
       }else{
           throw new prestamoException("no se encontro el libro con el titulo"+i);
       }
   }

   if (cliente.isPresent()) {
    prestamo.setLibros(libros);
    prestamo.setCliente(cliente.get());
    prestamo.setFechaDePrestamo(prestamoDTO.getFechaDePrestamo());
    prestamo.setFechaDeEntrega(prestamoDTO.getFechaDeEntrega());
    prestamo.setEstadoPrestamo(true);
    prestamoRepo.save(prestamo);
   }else{
     throw new personaException("no se encontro la persona con el email "+prestamoDTO.getEmailCliente());
   }
}

@Override
@Transactional
public void delete(Long id) {
  if (personaRepo.existsById(id)) {
    prestamoRepo.deleteById(id);
  }else{
    throw new prestamoException("no se encontro el prestamo con el id "+id);
  }
  
}

@Override
@Transactional
public void addBook(Long id, String titulo) {
   Optional<prestamo>prestamo=prestamoRepo.findById(id);
    if (!prestamo.isPresent()) {
        throw new prestamoException("no se encontro el prestamo con el id"+id);
    }
    libro libro=libroRepo.findByTituloIgnoreCase(titulo).orElseThrow(()->new libroException("no se encontrro el libro"));
    libro.setEstado(false);
    libroRepo.save(libro);
    prestamo.get().setLibros(List.of(libro));
    prestamoRepo.save(prestamo.get());

}

    @Override
    @Transactional
    public void returnBook(Long id,String titulo) {
        Optional<prestamo>prestamo=prestamoRepo.findById(id);
        if (prestamo.isPresent()){
            if (prestamo.get().getFechaDeEntrega().isBefore(LocalDate.now())){
                throw new prestamoAtrasadoException("el prestamo esta atrasado");
            }
            libro libro=libroRepo.findByTituloIgnoreCase(titulo).orElseThrow(()->new libroException("libro no encontrado"));
            libro.setEstado(true);
            libroRepo.save(libro);
            List<libro>libros=new ArrayList<>();
            for (libro i:prestamo.get().getLibros()){
                if (i.getTitulo().equalsIgnoreCase(libro.getTitulo())){
                    continue;
                }
                libros.add(i);
            }
            prestamo.get().setLibros(libros);
            if (prestamo.get().getLibros().isEmpty()){
                prestamo.get().setEstadoPrestamo(false);
            }
            prestamoRepo.save(prestamo.get());
        }else{
            throw  new prestamoException("no se encontro el prestamo con el id "+id);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<prestamoDto>lateLoans() {
        List<prestamo>prestamos=prestamoRepo.findByFechaDeEntregaLessThan(LocalDate.now());
        if (prestamos.isEmpty()){
            throw new noHayContenidoException();
        }
        return mapper.toprestamosDto(prestamos);
    }

    @Override
    @Transactional(readOnly = true)
    public List<prestamoDto> loansEarrings() {
        List<prestamo>prestamos=prestamoRepo.findByEstadoPrestamoFalse();
        if (prestamos.isEmpty()){
            throw new noHayContenidoException();
        }else{
            return mapper.toprestamosDto(prestamos);
        }
    }

}
