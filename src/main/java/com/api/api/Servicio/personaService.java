package com.api.api.Servicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.Entidades.DTO.personaDTO;
import com.api.api.Entidades.Entities.persona;
import com.api.api.Excepciones.personaException;
import com.api.api.Repositorio.personaRepositorio;

@Service
public class personaService {
   @Autowired
   private personaRepositorio personaRepo;

   public List<persona> getPersonas(){
    return personaRepo.findAll();
   }

   public persona getPersona(Long id){
    return personaRepo.findById(id).orElseThrow(()-> new personaException("no se encontro ala persona con el id "+id));
   }

   public persona createPersona(personaDTO personaDTO){
    persona persona=new persona();
    persona.setNombre(personaDTO.getNombre());
    return personaRepo.save(persona);
   }

   public persona updatePersona(Long id,personaDTO personaDTO){
    persona persona=personaRepo.findById(id).orElseThrow(()-> new personaException("no se econtro ala persona con el id"+id));
    persona.setNombre(personaDTO.getNombre());
    return personaRepo.save(persona);
   }
   
   public void deletePersona(Long id){
    persona persona=personaRepo.findById(id).orElseThrow(()-> new personaException("no se encontro ala persona con el id"+id));
    personaRepo.delete(persona);
   }

   public persona searchPersona(String nombre){
    return personaRepo.findByNombre(nombre).orElseThrow(()-> new personaException("no se encontro ala persona con el nombre "+nombre));
   }


}
