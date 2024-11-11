package com.api.api.Servicio.Interface;


import java.util.Optional;

import com.api.api.Model.DTO.clienteDto;

import java.util.List;
public interface Icliente {
   public List<clienteDto> findAll();

   public clienteDto findById(Long id);

   public void save(clienteDto personadDto);

    public void update(Long id, clienteDto persona);
   
   public void deleteById(Long id);

   public clienteDto findByEmail(String email);
}
