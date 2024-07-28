package com.api.api.persistencia;


import java.util.Optional;

import com.api.api.Model.DTO.personaDto;

import java.util.List;
public interface IpersonaDAO {
   public List<personaDto> findAll();

   public Optional<personaDto> findById(Long id);

   public void save(personaDto personadDto);

    public void update(Long id,personaDto persona);
   
   public void deleteById(Long id);

   public Optional<personaDto> findByEmail(String email);
}
