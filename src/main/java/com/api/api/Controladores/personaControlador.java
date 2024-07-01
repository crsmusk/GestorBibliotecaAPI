package com.api.api.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.api.Entidades.DTO.personaDTO;
import com.api.api.Entidades.Entities.persona;
import com.api.api.Servicio.personaService;

import jakarta.validation.Valid;
//import com.api.api.Servicio.prestamoService;
@RequestMapping("/persona")
@RestController
public class personaControlador {
  @Autowired
  private personaService personaService;

  @GetMapping
  public List<persona>getAllPersona(){
   return personaService.getPersonas();
  }

  @GetMapping("/{id}")
  public persona getPersona(@PathVariable Long id){
    return personaService.getPersona(id);
  }

  @PostMapping
  public persona createPersona(@Valid@RequestBody personaDTO personaDTO){
    return personaService.createPersona(personaDTO);
  }

  @PutMapping("/{id}")
  public persona updatePersona(@PathVariable Long id,@Valid@RequestBody personaDTO personaDTO){
    return personaService.updatePersona(id, personaDTO);
  }

  @DeleteMapping("/{id}")
  public void deletePersona(@PathVariable Long id){
     personaService.deletePersona(id);
  }

  @GetMapping("/buscarPersona/{nombre}")
  public persona searchPersona(@PathVariable String nombre){
    return personaService.searchPersona(nombre);
  }


}
