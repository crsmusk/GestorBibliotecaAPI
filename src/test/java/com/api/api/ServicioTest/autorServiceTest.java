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

import com.api.api.Excepciones.Exceptions.autorException;
import com.api.api.Model.DTO.autorDto;
import com.api.api.Repositorio.autorRepository;
import com.api.api.Servicio.Impl.autorService;

/*@SpringBootTest
public class autorServiceTest {
 private autorDto autorDtoEsperado;
 private Long id;

 @Autowired
 private autorService autorService;
 @Autowired 
 private autorRepository autorRepo;

 @BeforeEach
 public void setUp(){
    autorDtoEsperado=new autorDto();
    autorDtoEsperado.setNombre("stephen king");
    autorService.save(autorDtoEsperado);
 }

 @Test
 public void autor_Find_By_Id(){
    id=autorRepo.findByNombreIgnoreCase(autorDtoEsperado.getNombre()).get().getId();
    Optional<autorDto>autorDtoOptenido=autorService.findById(id);

    assertTrue(autorDtoOptenido.isPresent());
    assertEquals(autorDtoEsperado, autorDtoOptenido.get());
 }

 @Test
 public void autor_find_By_Nombre(){
    Optional<autorDto>autorDtoOptenido=autorService.findByNombre("stephen king");

    assertTrue(autorDtoOptenido.isPresent());
    assertEquals(autorDtoEsperado, autorDtoOptenido.get());
 }

 @Test
 public void autor_Update(){
    id=autorRepo.findByNombreIgnoreCase(autorDtoEsperado.getNombre()).get().getId();
    autorDtoEsperado.setNombre("gabriel garcia marquez");
    autorService.update(id, autorDtoEsperado);

   Optional<autorDto> autorDtoOtenido=autorService.findById(id);

   assertTrue(autorDtoOtenido.isPresent());
   assertEquals(autorDtoEsperado, autorDtoOtenido.get());
    
 }

 @Test
 public void autor_Find_By_Id_Exception(){
    assertThrows(autorException.class, ()->{
        autorService.findById(56L);
    });
 }

 @AfterEach
 public void delete_class(){
    id=autorRepo.findByNombreIgnoreCase(autorDtoEsperado.getNombre()).get().getId();
    autorService.delete(id);
 }
}
*/