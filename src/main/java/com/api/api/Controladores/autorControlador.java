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

import com.api.api.Excepciones.Exceptions.autorException;
import com.api.api.Model.DTO.autorDto;
import com.api.api.Servicio.Impl.autorService;

@RestController
@RequestMapping("/autores")
public class autorControlador {
 @Autowired
 private autorService autorService;
 
 @GetMapping
 public List<autorDto>getAll(){
    return autorService.findAll();
 }
 @GetMapping("/{id}")
 public ResponseEntity<Optional<autorDto>>getById(@PathVariable Long id){
    if(autorService.findById(id).isPresent()){
        return new ResponseEntity<>(autorService.findById(id),HttpStatus.OK);
    }else{
        throw new autorException();
    }
 }
 @GetMapping("/buscarAutor/{nombre}")
 public ResponseEntity<Optional<autorDto>>getByNombre(@PathVariable String nombre){
    if(autorService.findByNombre(nombre).isPresent()){
        return new ResponseEntity<>(autorService.findByNombre(nombre),HttpStatus.OK);
    }else{
        throw new autorException();
    }
 }
 @PostMapping
 public ResponseEntity<?>save(@RequestBody autorDto autorDto){
    autorService.save(autorDto);
    return new ResponseEntity<>(HttpStatus.CREATED);
 }
 @PutMapping("/{id}")
 public ResponseEntity<?>update(@RequestBody autorDto autorDto,@PathVariable Long id){
    autorService.update(id, autorDto);
    return new ResponseEntity<>(HttpStatus.OK);
 }
 @DeleteMapping("/{id}")
 public ResponseEntity<?>delete(@PathVariable Long id){
    autorService.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
 }
}
