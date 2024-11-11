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
import com.api.api.Model.DTO.clienteDto;
import com.api.api.Repositorio.clienteRepository;
import com.api.api.Servicio.Impl.clienteService;

/*@SpringBootTest
public class clienteServiceTest {
  private clienteDto clienteDtoEsperada;
  private Long id;

  @Autowired
  private clienteService clienteService;
  @Autowired
  private clienteRepository personaRepo;

  @BeforeEach
  public void setUp(){
    clienteDtoEsperada =new clienteDto();
    clienteDtoEsperada.setEmail("pepe@Gmail.com");
    clienteDtoEsperada.setContraseña("snape");
    clienteService.save(clienteDtoEsperada);
  }

  @Test
  public void persona_Find_By_Id(){
    id=personaRepo.findByEmail(clienteDtoEsperada.getEmail()).get().getId();
    Optional<clienteDto> personaDtoOptenida= clienteService.findById(id);

    assertTrue(personaDtoOptenida.isPresent());
    assertEquals(clienteDtoEsperada, personaDtoOptenida.get());
  }

  @Test
  public void persona_Find_By_Email(){
    Optional<clienteDto>personaDtoOptenida= clienteService.findByEmail("pepe@Gmail.com");

    assertTrue(personaDtoOptenida.isPresent());
    assertEquals(clienteDtoEsperada, personaDtoOptenida.get());
  }

  @Test
  public void persona_update(){
    id=personaRepo.findByEmail(clienteDtoEsperada.getEmail()).get().getId();
    clienteDtoEsperada.setEmail("lobo@Gmail.com");
    clienteService.update(id, clienteDtoEsperada);

    Optional<clienteDto>personaDtoOptenida= clienteService.findById(id);

    assertTrue(personaDtoOptenida.isPresent());
    assertEquals(clienteDtoEsperada, personaDtoOptenida.get());
  }

  @Test
  public void persona_Find_By_Id_Exception(){
    assertThrows(personaException.class, ()->{
        clienteService.findById(67L);
    });
  }


  @AfterEach
  public void delete_class(){
    id=personaRepo.findByEmail(clienteDtoEsperada.getEmail()).get().getId();
    clienteService.deleteById(id);
  }
}*/
