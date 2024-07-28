package com.api.api.persistencia;


import java.util.List;
import java.util.Optional;

import com.api.api.Model.DTO.prestamoDto;
public interface IprestamoDAO {
  
    public List<prestamoDto> findAll();

    public Optional<prestamoDto> findById(Long id);

    public void save(prestamoDto prestamo);

    public void delete(Long id);

    public void update(Long id,prestamoDto prestamo);
}
