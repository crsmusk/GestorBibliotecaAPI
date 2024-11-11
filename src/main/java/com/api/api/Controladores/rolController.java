package com.api.api.Controladores;

import com.api.api.Model.DTO.rolDto;
import com.api.api.Servicio.Impl.rolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rol")
public class rolController {
    @Autowired
    rolService rolService;

    @GetMapping
    public ResponseEntity<List<rolDto>>getAll(){
        return new ResponseEntity<>(rolService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/buscar-por-nombre/{nombre}")
    public ResponseEntity<rolDto> getByName(@PathVariable String nombre){
        return new ResponseEntity<>(rolService.findByNameRol(nombre),HttpStatus.OK);
    }
    @GetMapping("/buscar-por-id/{id}")
    public ResponseEntity<rolDto>getById(@PathVariable Long id){
        return new ResponseEntity<>(rolService.findById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?>save(@RequestBody rolDto rolDto){
        rolService.save(rolDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<?>changePermissions(@PathVariable Long id,@RequestBody List<String>roles){
        rolService.changePermissions(id,roles);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable Long id){
        rolService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
