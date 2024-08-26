package com.api.api.ServicioTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.api.Excepciones.Exceptions.generoException;
import com.api.api.Model.DTO.generoDto;
import com.api.api.Repositorio.generoRepository;
import com.api.api.Servicio.Impl.generoService;

@SpringBootTest
public class generoServiceTest {
 private generoDto generoDtoEsperado;
 private Long id;

 @Autowired
  private generoService generoService;
  @Autowired
  private generoRepository generoRepo;

  @BeforeEach
  public void setUp(){
    generoDtoEsperado=new generoDto();
    generoDtoEsperado.setNombreGenero("Fantasia");
    generoService.save(generoDtoEsperado);
  }

  @Test
  public void genero_Find_By_Id(){
    id=generoRepo.findByNombreGeneroIgnoreCase(generoDtoEsperado.getNombreGenero()).get().getId();
    Optional<generoDto>generoDtoOptenido=generoService.findById(id);

    assertTrue(generoDtoOptenido.isPresent());
    assertEquals(generoDtoEsperado, generoDtoOptenido.get());
  }

  @Test
  public void genero_Find_By_Nombre(){
    Optional<generoDto>generoDtoOptenido=generoService.findByNombre("Fantasia");

    assertTrue(generoDtoOptenido.isPresent());
    assertEquals(generoDtoEsperado, generoDtoOptenido.get());
  }

  @Test
  public void genero_Update(){
    id=generoRepo.findByNombreGeneroIgnoreCase(generoDtoEsperado.getNombreGenero()).get().getId();
    generoDtoEsperado.setNombreGenero("thriller");
    generoService.update(id, generoDtoEsperado);

    Optional<generoDto>generoDtoOptenido=generoService.findById(id);

    assertTrue(generoDtoOptenido.isPresent());
    assertEquals(generoDtoEsperado, generoDtoOptenido.get());
  }

  @Test
  public void genero_Find_By_Id_Exception(){
    assertThrows(generoException.class, ()->{
        generoService.findById(67L);
    });
  }

  @AfterEach
  public void delete_Class(){
    id=generoRepo.findByNombreGeneroIgnoreCase(generoDtoEsperado.getNombreGenero()).get().getId();
    generoService.delete(id);
  }
}
