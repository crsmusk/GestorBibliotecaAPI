package com.api.api.Controladores;

import com.api.api.Model.DTO.usuarioDto;
import com.api.api.Servicio.Impl.usuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class usuarioController {
    @Autowired
    usuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<usuarioDto>>getAll(){
        return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/buscar-por-nombre/{nombre}")
    public ResponseEntity<usuarioDto>getByName(@PathVariable String nombre){
        return new ResponseEntity<>(usuarioService.findByUserName(nombre),HttpStatus.OK);
    }
    @GetMapping("/buscar-por-id/{id}")
    public ResponseEntity<usuarioDto>getById(@PathVariable Long id){
        return new ResponseEntity<>(usuarioService.findById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?>save(@RequestBody usuarioDto usuarioDto){
        usuarioService.save(usuarioDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable Long id,@RequestBody usuarioDto usuarioDto){
        usuarioService.update(id,usuarioDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PatchMapping("/id")
    public ResponseEntity<?>changeRols(@PathVariable Long id,@RequestBody List<String>roles){
        usuarioService.changeRols(id,roles);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PatchMapping("/cambiar-nombre/{id}")
    public ResponseEntity<?>changeUserName(@PathVariable Long id,@RequestBody String nombre){
        usuarioService.changeUserName(id,nombre);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/id")
    public ResponseEntity<?>delete(@PathVariable Long id){
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
