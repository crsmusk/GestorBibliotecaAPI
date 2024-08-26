package com.api.api.Servicio.Interface;


import java.util.List;
import java.util.Optional;

import com.api.api.Model.DTO.prestamoDto;
public interface Iprestamo {
  
    public List<prestamoDto> findAll();

    public Optional<prestamoDto> findById(Long id);

    public void save(prestamoDto prestamo);

    public void delete(Long id);

    public void update(Long id,prestamoDto prestamo);
}
