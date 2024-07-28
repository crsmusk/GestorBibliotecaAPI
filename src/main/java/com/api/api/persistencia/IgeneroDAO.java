package com.api.api.persistencia;

import java.util.List;
import java.util.Optional;

import com.api.api.Model.DTO.generoDto;

public interface IgeneroDAO {
  public List<generoDto>findAll();
  public Optional<generoDto>findById(Long id);
  public Optional<generoDto>findByNombre(String nombreGenero);
  public void update(Long id,generoDto generoDto);
  public void save(generoDto generoDto);
  public void delete(Long id);
  
}
