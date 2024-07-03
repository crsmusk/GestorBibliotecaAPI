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

import com.api.api.Entidades.DTO.prestamoDTO;
import com.api.api.Servicio.prestamoService;

import jakarta.validation.Valid;
@RequestMapping("/prestamo")
@RestController
public class prestamoControlador {
   @Autowired
   private prestamoService prestamoService;

   @GetMapping
   public List<prestamoDTO> getAllPrestamos(){
    return prestamoService.findAll();
   }

   @GetMapping("/{id}")
   public Optional<prestamoDTO> getPrestamo(@PathVariable Long id){
    return prestamoService.findById(id);
   }

   @PostMapping
   public ResponseEntity<?>createPrestamo(@Valid@RequestBody prestamoDTO prestamoDTO){
     prestamoService.save(prestamoDTO);
     return ResponseEntity.ok("registro exitoso");
   }

   @PutMapping("/{id}")
   public ResponseEntity<?> updatePrestamo(@PathVariable Long id,@Valid@RequestBody prestamoDTO prestamoDTO){
     prestamoService.update(id, prestamoDTO);
     return ResponseEntity.ok("se guardaron los datos de forma exitosa");
   }

   @DeleteMapping("/{id}")
   public void deletePrestamo(@PathVariable Long id){
    prestamoService.delete(id);
   }
   

}
