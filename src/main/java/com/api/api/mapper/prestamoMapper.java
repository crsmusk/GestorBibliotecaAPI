package com.api.api.mapper;

import org.springframework.stereotype.Component;
import java.util.List;
import com.api.api.Model.DTO.prestamoDto;
import com.api.api.Model.Entities.prestamo;

@Component
public class prestamoMapper {
 public prestamoDto toPrestamoDto(prestamo prestamo){
    return prestamoDto.builder()
    .fechaDeEntrega(prestamo.getFechaDeEntrega())
    .fechaDePrestamo(prestamo.getFechaDePrestamo())
    .libro(prestamo.getLibro())
    .persona(prestamo.getPersona())
    .build();
 }

 public List<prestamoDto>toprestamosDto(List<prestamo>prestamos){
    return prestamos.stream().map(this::toPrestamoDto).toList();
 }
 
}
