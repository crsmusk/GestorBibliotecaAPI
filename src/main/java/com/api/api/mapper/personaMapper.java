package com.api.api.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.api.api.Model.DTO.personaDto;
import com.api.api.Model.Entities.persona;

@Component
public class personaMapper {
  public personaDto toPersonaDto(com.api.api.Model.Entities.persona persona){
    return personaDto.builder()
    .email(persona.getEmail())
    .contraseña(persona.getContraseña())
    .build();
  }
  public List<personaDto> toPersonasDto(List<persona>personas){
    return personas.stream().map(this::toPersonaDto).toList();
  }

  public persona toPersona(personaDto personaDto){
    persona persona=new persona();
    persona.setEmail(personaDto.getEmail());
    persona.setContraseña(personaDto.getContraseña());
    return persona;
  }
}
