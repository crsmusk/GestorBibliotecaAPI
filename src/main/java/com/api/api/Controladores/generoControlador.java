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

import com.api.api.Excepciones.Exceptions.generoException;
import com.api.api.Model.DTO.generoDto;
import com.api.api.Servicio.generoService;

@RestController
@RequestMapping("/generos")
public class generoControlador {
@Autowired
private generoService generoService;

@GetMapping
public List<generoDto>getAll(){
    return generoService.findAll();
}

@GetMapping("/{id}")
public ResponseEntity<Optional<generoDto>>getById(@PathVariable Long id){
    if(generoService.findById(id).isPresent()){
        return new ResponseEntity<>(generoService.findById(id),HttpStatus.OK);
    }else{
        throw new generoException();
    }
}

@GetMapping("/BuscarGenero/{nombre}")
public ResponseEntity<Optional<generoDto>>getByNombre(@PathVariable String nombre){
    if(generoService.findByNombre(nombre).isPresent()){
        return new ResponseEntity<>(generoService.findByNombre(nombre),HttpStatus.OK);
    }else{
        throw new generoException();
    }
}

@PutMapping("/{id}")
public ResponseEntity<?>update(@RequestBody generoDto generoDto,@PathVariable Long id){
    generoService.update(id, generoDto);
    return new ResponseEntity<>(HttpStatus.OK);
}

@PostMapping
public ResponseEntity<?>save(@RequestBody generoDto generoDto){
    generoService.save(generoDto);
    return new ResponseEntity<>(HttpStatus.CREATED);
}

@DeleteMapping("/{id}")
public ResponseEntity<?>delete(@PathVariable Long id){
    generoService.delete(id);
    return new ResponseEntity<>(HttpStatus.OK);
}
}