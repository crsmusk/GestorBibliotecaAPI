package com.api.api.mapper;

import org.springframework.stereotype.Component;
import java.util.List;
import com.api.api.Model.DTO.autorDto;
import com.api.api.Model.Entities.autor;

@Component
public class autorMapper {
  public autorDto toAutorDto(autor autor){
    return autorDto.builder()
    .nombre(autor.getNombre())
    .build();
  }
  public List<autorDto>toAutoresDto(List<autor>autores){
   return autores.stream().map(this::toAutorDto).toList();
  }
  public autor toAutor(autorDto autorDto){
    autor autor=new autor();
    autor.setNombre(autorDto.getNombre());
    return autor;
  }
}
