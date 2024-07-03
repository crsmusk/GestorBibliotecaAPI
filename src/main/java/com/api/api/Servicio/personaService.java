package com.api.api.Servicio;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.Entidades.DTO.personaDTO;

import com.api.api.Entidades.Entities.persona;
import com.api.api.Excepciones.personaException;
import com.api.api.Repositorio.personaRepositorio;
import com.api.api.persistencia.IpersonaDAO;

@Service
public class personaService implements IpersonaDAO{
   @Autowired
   private personaRepositorio personaRepo;

   @Override
   public List<personaDTO> findAll(){
      List<personaDTO>lista=personaRepo.findAll().stream().map(persona->personaDTO.builder()
      .nombre(persona.getNombre()).build()).toList();
      return lista;
   }

   @Override
   public Optional<personaDTO> findById(Long id) {
      persona perso=personaRepo.findById(id).orElseThrow(()-> new personaException("no se encontro ala persona"));
     personaDTO persona=personaDTO.builder()
     .nombre(perso.getNombre()).build();
     return Optional.of(persona);
   }

   @Override
   public void save(personaDTO personaDto) {
      persona persona=new persona();
      persona.setNombre(personaDto.getNombre());
      personaRepo.save(persona);
   }

   @Override
   public void deleteById(Long id) {
     personaRepo.deleteById(id);
   }

   @Override
   public Optional<personaDTO> findByNombre(String nombre) {
     persona perso=personaRepo.findByNombre(nombre).orElseThrow(()-> new personaException("no se econtro ala pesona "+nombre));
     personaDTO persona=personaDTO.builder()
     .nombre(perso.getNombre()).build();
     return Optional.of(persona);
   }

   @Override
   public void update(Long id, personaDTO personaDTO) {
      persona persona=personaRepo.findById(id).orElseThrow(()-> new personaException("no se econtro ala persona con el id"+id));
      persona.setNombre(personaDTO.getNombre());
      personaRepo.save(persona);
   }

  

}
