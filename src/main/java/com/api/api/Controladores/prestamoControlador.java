package com.api.api.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.api.api.Servicio.Impl.prestamoService;
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
   public ResponseEntity<prestamoDto> getPrestamo(@PathVariable Long id){
      return new ResponseEntity<>(prestamoService.findById(id),HttpStatus.OK);
   }

   @PostMapping
   public ResponseEntity<?>createPrestamo(@Valid@RequestBody prestamoDto prestamoDTO){
     prestamoService.save(prestamoDTO);
     return new ResponseEntity<>(HttpStatus.CREATED);
   }

   @PatchMapping("/agregar-libro/{id}/{titulo}")
   public ResponseEntity<?> addBook(@PathVariable Long id, @PathVariable String titulo){
     prestamoService.addBook(id, titulo);
     return ResponseEntity.ok("se actualizaron los datos de forma exitosa");
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<?> deletePrestamo(@PathVariable Long id){
    prestamoService.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
   }

   @PatchMapping("/devolver-libro/{id}/{titulo}")
    public ResponseEntity<?>returnBook(@PathVariable Long id,@PathVariable String titulo){
       prestamoService.returnBook(id,titulo);
       return new ResponseEntity<>(HttpStatus.OK);
   }

   @GetMapping("/prestamos-atrasados")
    public ResponseEntity<List<prestamoDto>>lateLoans(){
       return new ResponseEntity<>(prestamoService.lateLoans(),HttpStatus.OK);
   }

   @GetMapping("/prestamos-pendientes")
    public ResponseEntity<?>getLeansEarrings(){
       return new ResponseEntity<>(prestamoService.loansEarrings(),HttpStatus.OK);
   }

}
