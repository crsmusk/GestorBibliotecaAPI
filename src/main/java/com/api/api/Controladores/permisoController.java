package com.api.api.Controladores;

import com.api.api.Model.DTO.permisoDto;
import com.api.api.Servicio.Impl.permisoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permiso")
public class permisoController {

    @Autowired
    permisoService permisoService;

    @GetMapping
    public ResponseEntity<List<permisoDto>>getAll(){
        return new ResponseEntity<>(permisoService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/buscar-por-nombre/{nombre}")
    public ResponseEntity<permisoDto>getByName(@PathVariable String nombre){
        return new ResponseEntity<>(permisoService.findByName(nombre),HttpStatus.OK);
    }
    @GetMapping("/buscar-por-id/{id}")
    public ResponseEntity<permisoDto>getById(@PathVariable Long id){
        return new ResponseEntity<>(permisoService.findById(id),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?>save(@RequestBody permisoDto permisoDto){
        permisoService.save(permisoDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>update(@PathVariable Long id,@RequestBody permisoDto permisoDto){
        permisoService.update(id,permisoDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?>delete(@PathVariable Long  id){
        permisoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
