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

import com.api.api.Servicio.Impl.libroService; 
import com.api.api.Excepciones.Exceptions.libroException;
import com.api.api.Model.DTO.libroDto;
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

 @GetMapping("/buscar-libro-por-id/{id}")
 public ResponseEntity<libroDto> getLibro(@PathVariable Long id){
    
      return new ResponseEntity<>(libroService.findById(id),HttpStatus.OK);
 }

 @GetMapping("/libros-disponibles")
 public ResponseEntity<List<libroDto>> librosAvailable(){
   if(libroService.BooksAvailable().isEmpty()){
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }else{
      return new ResponseEntity<>(libroService.BooksAvailable(),HttpStatus.OK);
   }
 }

 @GetMapping("/buscar-libros-por-autor/{autor}")
 public ResponseEntity<List<libroDto>>getByAutor(@PathVariable String autor){
     return new ResponseEntity<>(libroService.findByAuthor(autor),HttpStatus.OK);
 }

 @GetMapping("/libros-no-disponibles")
 public ResponseEntity<List<libroDto>>librosNoAvailable(){
   if(libroService.BooksNotAvailable().isEmpty()){
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }else{
      return new ResponseEntity<>(libroService.BooksNotAvailable(),HttpStatus.OK);
   }
 }

 @GetMapping("/buscar-libros-por-genero/{genero}")
 public ResponseEntity<List<libroDto>>getByGenero(@PathVariable String genero){
     return new ResponseEntity<>(libroService.findByGender(genero),HttpStatus.OK);
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
 @GetMapping("/buscar-por-titulo/{titulo}")
 public ResponseEntity<libroDto> searchLibroByTitulo(@PathVariable String titulo){
      return new ResponseEntity<>(libroService.findByTitulo(titulo),HttpStatus.OK);
 }

}
