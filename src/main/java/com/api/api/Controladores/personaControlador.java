package com.api.api.Controladores;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.api.Servicio.Impl.personaService;
import com.api.api.Excepciones.Exceptions.personaException;
import com.api.api.Model.DTO.personaDto;
import jakarta.validation.Valid;
@RequestMapping("/personas")
@RestController
public class personaControlador {
  @Autowired
  private personaService personaService;

  @GetMapping
  public List<personaDto>getAllPersona(){
   return personaService.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<personaDto>> getPersona(@PathVariable Long id){
    if(personaService.findById(id).isPresent()){
      return new ResponseEntity<>(personaService.findById(id),HttpStatus.OK);
    }else{
      throw new personaException("persona no encontrada");
    }
    
  }

  @PostMapping
  public ResponseEntity<?> createPersona(@Valid@RequestBody personaDto personaDTO){
     personaService.save(personaDTO);
     return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updatePersona(@PathVariable Long id,@Valid@RequestBody personaDto personaDTO){
     personaService.update(id, personaDTO);
     return ResponseEntity.ok("se guardaron los cambios con exito");
  }

  @DeleteMapping("/{id}")
  public void deletePersona(@PathVariable Long id){
     personaService.deleteById(id);
  }

  @GetMapping("/buscarPersonaPorEmail/{email}")
  public ResponseEntity<Optional<personaDto>> searchPersona(@PathVariable String email){
    if(personaService.findByEmail(email).isPresent()){
      return new ResponseEntity<>(personaService.findByEmail(email),HttpStatus.OK);
    }else{
      throw new personaException("persona no encontrada");
    }
  }

}
