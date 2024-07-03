package com.api.api.Controladores;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.api.Entidades.DTO.personaDTO;

import com.api.api.Servicio.personaService;

import jakarta.validation.Valid;
//import com.api.api.Servicio.prestamoService;
@RequestMapping("/persona")
@RestController
public class personaControlador {
  @Autowired
  private personaService personaService;

  @GetMapping
  public List<personaDTO>getAllPersona(){
   return personaService.findAll();
  }

  @GetMapping("/{id}")
  public Optional<personaDTO> getPersona(@PathVariable Long id){
    return personaService.findById(id);
  }

  @PostMapping
  public ResponseEntity<?> createPersona(@Valid@RequestBody personaDTO personaDTO){
     personaService.save(personaDTO);
     return ResponseEntity.ok("registro exitoso");
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updatePersona(@PathVariable Long id,@Valid@RequestBody personaDTO personaDTO){
     personaService.update(id, personaDTO);
     return ResponseEntity.ok("se guardaron los cambios con exito");
  }

  @DeleteMapping("/{id}")
  public void deletePersona(@PathVariable Long id){
     personaService.deleteById(id);
  }

  @GetMapping("/buscarPersona/{nombre}")
  public Optional<personaDTO> searchPersona(@PathVariable String nombre){
    return personaService.findByNombre(nombre);
  }

}
