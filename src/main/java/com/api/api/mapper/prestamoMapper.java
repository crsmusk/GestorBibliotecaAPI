package com.api.api.mapper;

import com.api.api.Model.Entities.libro;
import org.springframework.stereotype.Component;
import java.util.List;
import com.api.api.Model.DTO.clienteDto;
import com.api.api.Model.DTO.libroDto;
import com.api.api.Model.DTO.clienteDto;
import com.api.api.Model.DTO.prestamoDto;
import com.api.api.Model.Entities.prestamo;

@Component
public class prestamoMapper {
 public prestamoDto toPrestamoDto(prestamo prestamo){
  prestamoDto prestamos=prestamoDto.builder()
          .fechaDePrestamo(prestamo.getFechaDePrestamo())
          .fechaDeEntrega(prestamo.getFechaDeEntrega())
          .nombreLibro(prestamo.getLibros().stream().map(libro::getTitulo).toList())
          .emailCliente(prestamo.getCliente().getEmail())
          .build();
  return prestamos;
 }

 public List<prestamoDto>toprestamosDto(List<prestamo>prestamos){
    return prestamos.stream().map(this::toPrestamoDto).toList();
 }
 
}
