package com.api.api.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.Excepciones.Exceptions.generoException;
import com.api.api.Model.DTO.generoDto;
import com.api.api.Model.Entities.genero;
import com.api.api.Repositorio.generoRepository;
import com.api.api.mapper.generoMapper;
import com.api.api.persistencia.IgeneroDAO;

@Service
public class generoService implements IgeneroDAO{
  @Autowired
  private generoRepository generoRepo;
  @Autowired
  private generoMapper mapper;
@Override
public List<generoDto> findAll() {
    List<generoDto>generos=mapper.toGenerosDto(generoRepo.findAll());
    return generos;
}
@Override
public Optional<generoDto> findById(Long id) {
    genero gender=generoRepo.findById(id).orElseThrow(()->new RuntimeException());
    generoDto genero=mapper.toGeneroDto(gender);
    return Optional.of(genero);
}
@Override
public Optional<generoDto> findByNombre(String nombreGenero) {
   genero gender=generoRepo.findByNombreGeneroIgnoreCase(nombreGenero).orElseThrow(()->new generoException());
   generoDto genero=mapper.toGeneroDto(gender);
   return Optional.of(genero);
}
@Override
public void update(Long id, generoDto generoDto) {
    genero gender=generoRepo.findById(id).orElseThrow(()->new RuntimeException());
    gender.setNombreGenero(generoDto.getNombreGenero());
}
@Override
public void save(generoDto generoDto) {
   generoRepo.save(mapper.toGenero(generoDto));
}
@Override
public void delete(Long id) {
    generoRepo.deleteById(id);
}
}
