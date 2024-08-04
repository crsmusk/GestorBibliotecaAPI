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

import com.api.api.Excepciones.Exceptions.personaException;
import com.api.api.Model.DTO.personaDto;
import com.api.api.Repositorio.personaRepository;
import com.api.api.Servicio.personaService;

@SpringBootTest
public class personaServiceTest {
  private personaDto personaDtoEsperada;
  private Long id;

  @Autowired
  private personaService personaService;
  @Autowired
  private personaRepository personaRepo;

  @BeforeEach
  public void setUp(){
    personaDtoEsperada=new personaDto();
    personaDtoEsperada.setEmail("pepe@Gmail.com");
    personaDtoEsperada.setContraseña("snape");
    personaService.save(personaDtoEsperada);
  }

  @Test
  public void persona_Find_By_Id(){
    id=personaRepo.findByEmail(personaDtoEsperada.getEmail()).get().getId();
    Optional<personaDto> personaDtoOptenida=personaService.findById(id);

    assertTrue(personaDtoOptenida.isPresent());
    assertEquals(personaDtoEsperada, personaDtoOptenida.get());
  }

  @Test
  public void persona_Find_By_Email(){
    Optional<personaDto>personaDtoOptenida=personaService.findByEmail("pepe@Gmail.com");

    assertTrue(personaDtoOptenida.isPresent());
    assertEquals(personaDtoEsperada, personaDtoOptenida.get());
  }

  @Test
  public void persona_update(){
    id=personaRepo.findByEmail(personaDtoEsperada.getEmail()).get().getId();
    personaDtoEsperada.setEmail("lobo@Gmail.com");
    personaService.update(id, personaDtoEsperada);

    Optional<personaDto>personaDtoOptenida=personaService.findById(id);

    assertTrue(personaDtoOptenida.isPresent());
    assertEquals(personaDtoEsperada, personaDtoOptenida.get());
  }

  @Test
  public void persona_Find_By_Id_Exception(){
    assertThrows(personaException.class, ()->{
        personaService.findById(67L);
    });
  }


  @AfterEach
  public void delete_class(){
    id=personaRepo.findByEmail(personaDtoEsperada.getEmail()).get().getId();
    personaService.deleteById(id);
  }
}
