package com.api.api.mapper;

import org.springframework.stereotype.Component;
import java.util.List;
import com.api.api.Model.DTO.generoDto;
import com.api.api.Model.Entities.genero;


@Component
public class generoMapper {
 public generoDto toGeneroDto(genero genero){
    return generoDto.builder()
    .nombreGenero(genero.getNombreGenero())
    .build();
 }

 public List<generoDto>toGenerosDto(List<genero>generos){
    return generos.stream().map(this::toGeneroDto).toList();
 }

 public genero toGenero(generoDto generoDto){
    genero genero=new genero();
    genero.setNombreGenero(generoDto.getNombreGenero());
    return genero;
 }
 
}
