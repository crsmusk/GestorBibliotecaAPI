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
import com.api.api.Servicio.Impl.prestamoService;
import com.api.api.Excepciones.Exceptions.prestamoException;
import com.api.api.Model.DTO.prestamoDto;
import jakarta.validation.Valid;
@RequestMapping("/prestamos")
@RestController
public class prestamoControlador {
   @Autowired
   private prestamoService prestamoService;

   @GetMapping
   public List<prestamoDto> getAllPrestamos(){
    return prestamoService.findAll();
   }

   @GetMapping("/{id}")
   public ResponseEntity<Optional<prestamoDto>> getPrestamo(@PathVariable Long id){
    if(prestamoService.findById(id).isPresent()){
      return new ResponseEntity<>(prestamoService.findById(id),HttpStatus.OK);
    }else{
      throw new prestamoException("prestamo no encontrado");
    }
   }

   @PostMapping
   public ResponseEntity<?>createPrestamo(@Valid@RequestBody prestamoDto prestamoDTO){
     prestamoService.save(prestamoDTO);
     return new ResponseEntity<>(HttpStatus.CREATED);
   }

   @PutMapping("/{id}")
   public ResponseEntity<?> updatePrestamo(@PathVariable Long id,@Valid@RequestBody prestamoDto prestamoDTO){
     prestamoService.update(id, prestamoDTO);
     return ResponseEntity.ok("se actualizaron los datos de forma exitosa");
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<?> deletePrestamo(@PathVariable Long id){
    prestamoService.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
   }
   

}
