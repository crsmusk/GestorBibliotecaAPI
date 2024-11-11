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
import com.api.api.Servicio.Impl.clienteService;
import com.api.api.Excepciones.Exceptions.personaException;
import com.api.api.Model.DTO.clienteDto;
import jakarta.validation.Valid;
@RequestMapping("/clientes")
@RestController
public class clienteControlador {
  @Autowired
  private clienteService clienteService;

  @GetMapping
  public List<clienteDto>getAllPersona(){
   return clienteService.findAll();
  }

  @GetMapping("/buscar-por-id/{id}")
  public ResponseEntity<clienteDto> getPersona(@PathVariable Long id){
      return new ResponseEntity<>(clienteService.findById(id),HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<?> createPersona(@Valid@RequestBody clienteDto clienteDTO){
     clienteService.save(clienteDTO);
     return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updatePersona(@PathVariable Long id,@Valid@RequestBody clienteDto clienteDTO){
     clienteService.update(id, clienteDTO);
     return ResponseEntity.ok("se guardaron los cambios con exito");
  }

  @DeleteMapping("/{id}")
  public void deletePersona(@PathVariable Long id){
     clienteService.deleteById(id);
  }

  @GetMapping("/buscar-persona-por-email/{email}")
  public ResponseEntity<clienteDto> searchPersona(@PathVariable String email){
      return new ResponseEntity<>(clienteService.findByEmail(email),HttpStatus.OK);
   
  }

}
