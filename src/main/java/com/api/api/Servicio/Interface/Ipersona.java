package com.api.api.Servicio.Interface;


import java.util.Optional;

import com.api.api.Model.DTO.personaDto;

import java.util.List;
public interface Ipersona {
   public List<personaDto> findAll();

   public Optional<personaDto> findById(Long id);

   public void save(personaDto personadDto);

    public void update(Long id,personaDto persona);
   
   public void deleteById(Long id);

   public Optional<personaDto> findByEmail(String email);
}
