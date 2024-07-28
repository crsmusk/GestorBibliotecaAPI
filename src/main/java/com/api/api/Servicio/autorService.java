package com.api.api.Servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.Excepciones.Exceptions.autorException;
import com.api.api.Model.DTO.autorDto;
import com.api.api.Model.Entities.autor;
import com.api.api.Repositorio.autorRepository;
import com.api.api.mapper.autorMapper;
import com.api.api.persistencia.IautorDAO;

@Service
public class autorService implements IautorDAO{
 @Autowired
 private autorRepository autorRepo;
 @Autowired
 private autorMapper mapper;
@Override
public List<autorDto> findAll() {
    List<autorDto>autores=mapper.toAutoresDto(autorRepo.findAll());
    return autores;
}
@Override
public Optional<autorDto> findById(Long id) {
    autor author=autorRepo.findById(id).orElseThrow(()->new autorException());
    autorDto autor=mapper.toAutorDto(author);
    return Optional.of(autor);
}
@Override
public Optional<autorDto> findByNombre(String nombre) {
    autor author=autorRepo.findByNombreIgnoreCase(nombre).orElseThrow(()->new autorException());
    autorDto autor=mapper.toAutorDto(author);
    return Optional.of(autor);
}
@Override
public void update(Long id, autorDto autorDto) {
    autor author=autorRepo.findById(id).orElseThrow(()->new autorException());
    author.setNombre(autorDto.getNombre());
}
@Override
public void save(autorDto autorDto) {
   autorRepo.save(mapper.toAutor(autorDto));
}
@Override
public void delete(Long id) {
  autorRepo.deleteById(id);
}
}
