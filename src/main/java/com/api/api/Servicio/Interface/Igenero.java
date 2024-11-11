package com.api.api.Servicio.Interface;

import java.util.List;


import com.api.api.Model.DTO.generoDto;

public interface Igenero {
  public List<generoDto>findAll();
  public generoDto findById(Long id);
  public generoDto findByNombre(String nombreGenero);
  public void update(Long id,generoDto generoDto);
  public void save(generoDto generoDto);
  public void delete(Long id);
  
}
