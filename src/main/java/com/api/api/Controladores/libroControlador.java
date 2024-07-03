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

import com.api.api.Entidades.DTO.libroDTO;
import com.api.api.Servicio.libroService;

import jakarta.validation.Valid;
@RequestMapping("/libro")
@RestController
public class libroControlador {
 @Autowired
 private libroService libroService;

 @GetMapping
 public List<libroDTO> getAllLibros(){
    return libroService.findAll();
 }

 @GetMapping("/{id}")
 public Optional<libroDTO> getLibro(@PathVariable Long id){
    return libroService.findById(id);
 }

 @PostMapping
 public ResponseEntity<?> createLibro(@Valid@RequestBody libroDTO libroDto){
      libroService.save(libroDto);
      return ResponseEntity.ok("registro exitoso");

 }

 @PutMapping("/{id}")
   public ResponseEntity<?>  updateLibro(@PathVariable Long id,@Valid@RequestBody libroDTO libroDTO){
    libroService.update(id, libroDTO);
    return ResponseEntity.ok("actualizacion exitosa");
 }

 @DeleteMapping("/{id}")
 public ResponseEntity<?> deleteLibro(@PathVariable Long id){
    libroService.deleteById(id);
    return ResponseEntity.ok("se elimino con exito");
 }
 @GetMapping("/buscarPorTitulo/{titulo}")
 public Optional<libroDTO> searchLibroByTitulo(@PathVariable String titulo){
    return libroService.findByTitulo(titulo);
 }

 @GetMapping("/buscarPorAutor/{autor}")
 public List<libroDTO> searchLibroByAutor(@PathVariable String autor){
    return libroService.findByAutor(autor);
 }

 @GetMapping("/buscarPorGenero/{genero}")
 public List<libroDTO> searchLibroByGenero(@PathVariable String genero){
    return libroService.findByGenero(genero);
 }
 

}
