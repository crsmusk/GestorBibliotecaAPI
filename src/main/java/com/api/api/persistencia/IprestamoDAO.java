package com.api.api.persistencia;


import java.util.List;
import java.util.Optional;

import com.api.api.Entidades.DTO.prestamoDTO;
public interface IprestamoDAO {
  
    public List<prestamoDTO> findAll();

    public Optional<prestamoDTO> findById(Long id);

    public void save(prestamoDTO prestamo);

    public void delete(Long id);

    public void update(Long id,prestamoDTO prestamo);
}
