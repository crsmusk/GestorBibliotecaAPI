package com.api.api.Servicio.Interface;

import java.util.List;
import java.util.Optional;

import com.api.api.Model.DTO.autorDto;

public interface Iautor {
  public List<autorDto>findAll();
  public Optional<autorDto>findById(Long id);
  public Optional<autorDto>findByNombre(String nombre);
  public void update(Long id,autorDto autorDto);
  public void save(autorDto autorDto);
  public void delete(Long id);
}
