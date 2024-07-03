package com.api.api.persistencia;


import java.util.Optional;

import com.api.api.Entidades.DTO.personaDTO;



import java.util.List;
public interface IpersonaDAO {
   public List<personaDTO> findAll();

   public Optional<personaDTO> findById(Long id);

   public void save(personaDTO personadDto);

    public void update(Long id,personaDTO persona);
   
   public void deleteById(Long id);

   public Optional<personaDTO> findByNombre(String nombre);
}
