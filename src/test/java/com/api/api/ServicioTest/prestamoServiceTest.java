package com.api.api.ServicioTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Optional;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.api.api.Excepciones.Exceptions.prestamoException;

import com.api.api.Model.DTO.libroDto;
import com.api.api.Model.DTO.clienteDto;
import com.api.api.Model.DTO.prestamoDto;

import com.api.api.Repositorio.prestamoRepository;

//se  crean de antemano los datos en la base de datos para poder testear mas facilmente el servicio de prestamo
import com.api.api.Servicio.Impl.prestamoService;

/*@SpringBootTest
public class prestamoServiceTest {
    private prestamoDto prestamoDtoEsperado;
    private Long id;
    private clienteDto persona;
    
    @Autowired
    prestamoService prestamoService;
    @Autowired
    prestamoRepository prestamoRepo;
    
     @BeforeEach
    public void setUp(){
        persona=new personaDto();
        persona.setEmail("pepe@Gmail.com");
        persona.setContraseña("madara123");

        libro=new libroDto();
        libro.setTitulo("el mecanico legendario");
        libro.setEstado(true);
        libro.setNombreAutor("kim jun");
        libro.setNombreGenero("fantasia");

        prestamoDtoEsperado=new prestamoDto();
        prestamoDtoEsperado.setFechaDePrestamo(LocalDate.now());
        prestamoDtoEsperado.setFechaDeEntrega(LocalDate.of(2017, 10, 15));
        prestamoDtoEsperado.setLibroDto(libro);
        prestamoDtoEsperado.setPersonaDto(persona);
        personaService.save(persona);
        libroService.save(libro);
        prestamoService.save(prestamoDtoEsperado);
        
    }
    

    
    @Test
    public void prestamo_Find_By_Id(){
        id=prestamoRepo.findAll().getFirst().getId();
        persona=new clienteDto();
        persona.setEmail("pepe@Gmail.com");
        persona.setContraseña("madara123");

        libroDto libro=new libroDto();
        libro.setTitulo("el mecanico legendario");
        libro.setEstado(true);
        libro.setNombreAutor("kim jun");
        libro.setNombreGenero("fantasia");

        prestamoDtoEsperado=new prestamoDto();
        prestamoDtoEsperado.setFechaDePrestamo(LocalDate.now());
        prestamoDtoEsperado.setFechaDeEntrega(LocalDate.of(2017, 10, 15));
        prestamoDtoEsperado.setLibroDto(libro);
        prestamoDtoEsperado.setClienteDto(persona);

        Optional<prestamoDto>prestamoDtoOptenido=prestamoService.findById(id);

        assertNotEquals(prestamoDtoEsperado.getLibroDto().isEstado(), prestamoDtoOptenido.get().getLibroDto().isEstado());

        
    }   

    @Test
    public void prestamo_update(){
        id=prestamoRepo.findAll().getFirst().getId();
        persona=new clienteDto();
        persona.setEmail("pepe@Gmail.com");
        persona.setContraseña("madara123");

        libroDto libro=new libroDto();
        libro.setTitulo("el mecanico legendario");
        libro.setEstado(true);
        libro.setNombreAutor("kim jun");
        libro.setNombreGenero("fantasia");

        prestamoDtoEsperado=new prestamoDto();
        prestamoDtoEsperado.setFechaDePrestamo(LocalDate.now());
        prestamoDtoEsperado.setFechaDeEntrega(LocalDate.of(2017, 10, 15));
        prestamoDtoEsperado.setLibroDto(libro);
        prestamoDtoEsperado.setClienteDto(persona);

        id=prestamoRepo.findAll().getFirst().getId();
        prestamoDtoEsperado.setFechaDeEntrega(LocalDate.of(2024, 06, 20));
        prestamoService.update(id, prestamoDtoEsperado);

        Optional<prestamoDto>prestamoDtoOptenido=prestamoService.findById(id);

        assertTrue(prestamoDtoOptenido.isPresent());
        assertEquals(prestamoDtoEsperado.getFechaDeEntrega(), prestamoDtoOptenido.get().getFechaDeEntrega());
    }

    @Test
    public void prestamo_Find_By_Id_Exception(){
        assertThrows(prestamoException.class, ()->{
            prestamoService.findById(40L);
        });
    }

   


}*/
