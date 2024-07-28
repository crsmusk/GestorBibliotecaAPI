package com.api.api.mapper;

import org.springframework.stereotype.Component;
import java.util.List;
import com.api.api.Model.DTO.libroDto;
import com.api.api.Model.Entities.libro;

@Component
public class libroMapper {
  
    public libroDto toLibroDto(libro libro){
        return libroDto.builder()
        .titulo(libro.getTitulo())
        .estado(libro.isEstado())
        .genero(libro.getGenero())
        .autor(libro.getAutor())
        .build();
    }
    public List<libroDto>tolibrosDto(List<libro>libros){
     return libros.stream().map(this::toLibroDto).toList();
    }
    public libro libro(libroDto libroDto){
        libro libro=new libro();
        libro.setTitulo(libroDto.getTitulo());
        libro.setEstado(libroDto.isEstado());
        libro.setAutor(libroDto.getAutor());
        libro.setGenero(libro.getGenero());
        return libro;

    }
}
