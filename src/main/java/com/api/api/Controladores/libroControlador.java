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

import com.api.api.Excepciones.Exceptions.libroException;
import com.api.api.Model.DTO.libroDto;
import com.api.api.Servicio.libroService;

import jakarta.validation.Valid;
@RequestMapping("/libros")
@RestController
public class libroControlador {
 @Autowired
 private libroService libroService;

 @GetMapping
 public List<libroDto> getAllLibros(){
    return libroService.findAll();
 }

 @GetMapping("/{id}")
 public ResponseEntity<Optional<libroDto>> getLibro(@PathVariable Long id){
    if(libroService.findById(id).isPresent()){
      return new ResponseEntity<>(libroService.findById(id),HttpStatus.OK);
    }else{
      throw new libroException("libro no encontrado");
    }
    
 }

 @PostMapping
 public ResponseEntity<?> createLibro(@Valid@RequestBody libroDto libroDto){
      libroService.save(libroDto);
      return new ResponseEntity<>(HttpStatus.CREATED);

 }

 @PutMapping("/{id}")
   public ResponseEntity<?>  updateLibro(@PathVariable Long id,@Valid@RequestBody libroDto libroDTO){
    libroService.update(id, libroDTO);
    return ResponseEntity.ok("actualizacion exitosa");
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<?> deleteLibro(@PathVariable Long id){
    libroService.deleteById(id);
    return ResponseEntity.ok("se elimino con exito");
 }
 @GetMapping("/buscarPorTitulo/{titulo}")
 public ResponseEntity<Optional<libroDto>> searchLibroByTitulo(@PathVariable String titulo){
   if(libroService.findByTitulo(titulo).isPresent()){
      return new ResponseEntity<>(libroService.findByTitulo(titulo),HttpStatus.OK);
   }else{
      throw new libroException("libro no encontrado");
   }
 }

}
