package com.api.api.Servicio;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.Excepciones.Exceptions.personaException;
import com.api.api.Model.DTO.personaDto;
import com.api.api.Model.Entities.persona;
import com.api.api.Repositorio.personaRepository;
import com.api.api.mapper.personaMapper;
import com.api.api.persistencia.IpersonaDAO;

@Service
public class personaService implements IpersonaDAO{
   @Autowired
   private personaRepository personaRepo;
   @Autowired
   private personaMapper mapper;

   @Override
   public List<personaDto> findAll(){
      List<personaDto>lista=mapper.toPersonasDto(personaRepo.findAll());
      return lista;
   }

   @Override
   public Optional<personaDto> findById(Long id) {
      persona perso=personaRepo.findById(id).orElseThrow(()-> new personaException("no se encontro ala persona"));
     personaDto persona=mapper.toPersonaDto(perso);
     return Optional.of(persona);
   }

   @Override
   public void save(personaDto personaDto) {
      personaRepo.save(mapper.toPersona(personaDto));
   }

   @Override
   public void deleteById(Long id) {
     personaRepo.deleteById(id);
   }

   @Override
   public Optional<personaDto> findByEmail(String email) {
     persona perso=personaRepo.findByEmail(email).orElseThrow(()-> new personaException("no se econtro ala persona con el email:"+email));
     personaDto persona=mapper.toPersonaDto(perso);
     return Optional.of(persona);
   }

   @Override
   public void update(Long id, personaDto personaDTO) {
      persona persona=personaRepo.findById(id).orElseThrow(()-> new personaException("no se econtro ala persona con el id"+id));
      persona.setEmail(personaDTO.getEmail());
      persona.setContraseña(personaDTO.getContraseña());
      personaRepo.save(persona);
   }

  

}
