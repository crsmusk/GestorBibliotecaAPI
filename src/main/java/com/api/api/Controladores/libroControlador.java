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

import com.api.api.Entidades.DTO.libroDTO;
import com.api.api.Entidades.Entities.libro;
import com.api.api.Servicio.libroService;

import jakarta.validation.Valid;
@RequestMapping("/libro")
@RestController
public class libroControlador {
 @Autowired
 private libroService libroService;

 @GetMapping
 public List<libro> getAllLibros(){
    return libroService.getLibros();
 }

 @GetMapping("/{id}")
 public libro getLibro(@PathVariable Long id){
    return libroService.getLibro(id);
 }

 @PostMapping
 public libro createLibro(@Valid@RequestBody libroDTO libroDto){
    return libroService.createLibro(libroDto);
 }

 @PutMapping("/{id}")
 public libro updateLibro(@PathVariable Long id,@Valid@RequestBody libroDTO libroDTO){
    return libroService.updateLibro(id, libroDTO);
 }

 @DeleteMapping("/{id}")
 public void deleteLibro(@PathVariable Long id){
    libroService.deleteLibro(id);
 }
 @GetMapping("/buscarPorTitulo/{titulo}")
 public libro searchLibroByTitulo(@PathVariable String titulo){
    return libroService.searchTitulo(titulo);
 }

 @GetMapping("/buscarPorAutor/{autor}")
 public List<libro> searchLibroByAutor(@PathVariable String autor){
    return libroService.searchAutor(autor);
 }

 @GetMapping("/buscarPorGenero/{genero}")
 public List<libro> searchLibroByGenero(@PathVariable String genero){
    return libroService.searchGenero(genero);
 }
 

}
