package com.api.api.Servicio.Impl;

import java.util.List;
import java.util.Optional;

import com.api.api.Excepciones.Exceptions.noHayContenidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.Excepciones.Exceptions.generoException;
import com.api.api.Model.DTO.generoDto;
import com.api.api.Model.Entities.genero;
import com.api.api.Repositorio.generoRepository;
import com.api.api.Servicio.Interface.Igenero;
import com.api.api.mapper.generoMapper;

@Service
public class generoService implements Igenero{
  @Autowired
  private generoRepository generoRepo;
  @Autowired
  private generoMapper mapper;


@Override
public List<generoDto> findAll() {
    List<genero>generos=generoRepo.findAll();
    if (generos.isEmpty()) {
        throw new noHayContenidoException();
    }
    return mapper.toGenerosDto(generos);
}
@Override
public generoDto findById(Long id) {
    genero gender=generoRepo.findById(id).orElseThrow(()->new generoException());
    generoDto genero=mapper.toGeneroDto(gender);
    return genero;
}
@Override
public generoDto findByNombre(String nombreGenero) {
   genero gender=generoRepo.findByNombreGeneroIgnoreCase(nombreGenero).orElseThrow(()->new generoException());
   generoDto genero=mapper.toGeneroDto(gender);
   return genero;
}
@Override
public void update(Long id, generoDto generoDto) {
    genero gender=generoRepo.findById(id).orElseThrow(()->new generoException());
    gender.setNombreGenero(generoDto.getNombreGenero());
    generoRepo.save(gender);
}
@Override
public void save(generoDto generoDto) {
   generoRepo.save(mapper.toGenero(generoDto));
}
@Override
public void delete(Long id) {
    if (generoRepo.existsById(id)) {
         generoRepo.deleteById(id);
    }else{
        throw new generoException();
    }
}
   
}
