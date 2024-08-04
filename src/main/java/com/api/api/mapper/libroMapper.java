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
        .nombreGenero(libro.getGenero().getNombreGenero())
        .nombreAutor(libro.getAutor().getNombre())
        .build();
    }
    public List<libroDto>tolibrosDto(List<libro>libros){
     return libros.stream().map(this::toLibroDto).toList();
    }
    
}
