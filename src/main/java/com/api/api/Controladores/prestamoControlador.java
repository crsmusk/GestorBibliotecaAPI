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

import com.api.api.Entidades.DTO.prestamoDTO;
import com.api.api.Entidades.Entities.prestamo;
import com.api.api.Servicio.prestamoService;

import jakarta.validation.Valid;
@RequestMapping("/prestamo")
@RestController
public class prestamoControlador {
   @Autowired
   private prestamoService prestamoService;

   @GetMapping
   public List<prestamo> getAllPrestamos(){
    return prestamoService.getPrestamos();
   }

   @GetMapping("/{id}")
   public prestamo getPrestamo(@PathVariable Long id){
    return prestamoService.getPrestamo(id);
   }

   @PostMapping
   public prestamo createPrestamo(@Valid@RequestBody prestamoDTO prestamoDTO){
    return prestamoService.createPrestamo(prestamoDTO);
   }

   @PutMapping("/{id}")
   public prestamo updatePrestamo(@PathVariable Long id,@Valid@RequestBody prestamoDTO prestamoDTO){
    return prestamoService.updatePrestamo(id, prestamoDTO);
   }

   @DeleteMapping("/{id}")
   public void deletePrestamo(@PathVariable Long id){
    prestamoService.deletePrestamo(id);
   }
   

}
