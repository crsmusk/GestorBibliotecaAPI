package com.api.api.mapper;

import org.springframework.stereotype.Component;
import java.util.List;

import com.api.api.Model.DTO.libroDto;
import com.api.api.Model.DTO.personaDto;
import com.api.api.Model.DTO.prestamoDto;
import com.api.api.Model.Entities.prestamo;

@Component
public class prestamoMapper {
 public prestamoDto toPrestamoDto(prestamo prestamo){
   libroDto libroDto=com.api.api.Model.DTO.libroDto.builder()
   .titulo(prestamo.getLibro().getTitulo())
   .estado(prestamo.getLibro().isEstado())
   .nombreAutor(prestamo.getLibro().getAutor().getNombre())
   .nombreGenero(prestamo.getLibro().getGenero().getNombreGenero())
   .build();
   personaDto personaDto=com.api.api.Model.DTO.personaDto.builder()
   .email(prestamo.getPersona().getEmail())
   .contraseña(prestamo.getPersona().getContraseña())
   .build();
    return prestamoDto.builder()
    .fechaDeEntrega(prestamo.getFechaDeEntrega())
    .fechaDePrestamo(prestamo.getFechaDePrestamo())
    .libroDto(libroDto)
    .personaDto(personaDto)
    .build();
 }

 public List<prestamoDto>toprestamosDto(List<prestamo>prestamos){
    return prestamos.stream().map(this::toPrestamoDto).toList();
 }
 
}
