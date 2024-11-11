package com.api.api.ServicioTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.api.Excepciones.Exceptions.libroException;
import com.api.api.Model.DTO.libroDto;
import com.api.api.Repositorio.libroRepository;
import com.api.api.Servicio.Impl.libroService; 

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

/*@SpringBootTest
public class libroServiceTest {
  private libroDto libroDtoEsperado;
  private Long id;
  
  @Autowired
  private libroService libroService;
  @Autowired
  private libroRepository libroRepo;

  //se crean de antemano el genero y el autor en la base de datos 

  @BeforeEach
  public void setUp(){
    //no es un libro pero sirve de ejemplo
    libroDtoEsperado=new libroDto();
    libroDtoEsperado.setEstado(true);
    libroDtoEsperado.setNombreAutor("chugong");
    libroDtoEsperado.setNombreGenero("fantasia");
    libroDtoEsperado.setTitulo("solo leveling");
    libroService.save(libroDtoEsperado);
  }

  @Test
  public void libro_Find_By_Id(){
    id=libroRepo.findByTituloIgnoreCase(libroDtoEsperado.getTitulo()).get().getId();
    Optional<libroDto>libroDtoOptenido=libroService.findById(id);

    assertTrue(libroDtoOptenido.isPresent());
    assertEquals(libroDtoEsperado, libroDtoOptenido.get());
  }

  @Test
  public void libro_Find_By_Titulo(){
    Optional<libroDto>libroDtoOptenido=libroService.findByTitulo("solo leveling");

    assertTrue(libroDtoOptenido.isPresent());
    assertEquals(libroDtoEsperado, libroDtoOptenido.get());
  }

  @Test
  public void libro_available(){
    List<libroDto>listLibroDisponible=libroService.BooksAvailable();
    libroDto libroDisponibleOptenido=listLibroDisponible.get(0);

    assertEquals(libroDtoEsperado, libroDisponibleOptenido);
  }

  @Test
    void libro_Not_Available(){
    id=libroRepo.findByTituloIgnoreCase(libroDtoEsperado.getTitulo()).get().getId();
    libroDtoEsperado.setEstado(false);
    libroService.update(id, libroDtoEsperado);

    List<libroDto>listLibrosDto=libroService.BooksNotAvailable();
    libroDto libroDtoOptenido=listLibrosDto.get(0);

    assertEquals(libroDtoEsperado, libroDtoOptenido);
  }

  @Test
  void libro_Update(){
    id=libroRepo.findByTituloIgnoreCase(libroDtoEsperado.getTitulo()).get().getId();
    libroDtoEsperado.setEstado(false);
    libroService.update(id, libroDtoEsperado);

    Optional<libroDto>libroDtoOptenido=libroService.findById(id);

    assertTrue(libroDtoOptenido.isPresent());
    assertEquals(libroDtoEsperado, libroDtoOptenido.get());
  }

  @Test
  void libro_find_Exception(){
    assertThrows(libroException.class, ()->{
        libroService.findById(56L);
    });
  }

  @AfterEach
  public void delete_Class(){
    id=libroRepo.findByTituloIgnoreCase(libroDtoEsperado.getTitulo()).get().getId();
    libroService.deleteById(id);
  }

}*/
