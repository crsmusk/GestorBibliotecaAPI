package com.api.api.Servicio.Impl;

import java.util.List;
import java.util.Optional;

import com.api.api.Excepciones.Exceptions.noHayContenidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.Excepciones.Exceptions.autorException;
import com.api.api.Model.DTO.autorDto;
import com.api.api.Model.Entities.autor;
import com.api.api.Repositorio.autorRepository;
import com.api.api.Servicio.Interface.Iautor;
import com.api.api.mapper.autorMapper;

@Service
public class autorService implements Iautor{
 @Autowired
 private autorRepository autorRepo;
 @Autowired
 private autorMapper mapper;
@Override
public List<autorDto> findAll() {
    List<autor>autores=autorRepo.findAll();
    if (autores.isEmpty()) {
        throw new noHayContenidoException();
    }
    return mapper.toAutoresDto(autores);
}
@Override
public autorDto findById(Long id) {
    autor author=autorRepo.findById(id).orElseThrow(()->new autorException());
    autorDto autor=mapper.toAutorDto(author);
    return autor;
}
@Override
public autorDto findByNombre(String nombre) {
    autor author=autorRepo.findByNombreIgnoreCase(nombre).orElseThrow(()->new autorException());
    autorDto autor=mapper.toAutorDto(author);
    return autor;
}
@Override
public void update(Long id, autorDto autorDto) {
    autor author=autorRepo.findById(id).orElseThrow(()->new autorException());
    author.setNombre(autorDto.getNombre());
    autorRepo.save(author);
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
