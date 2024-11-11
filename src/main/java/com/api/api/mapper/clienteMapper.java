package com.api.api.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.api.api.Model.DTO.clienteDto;
import com.api.api.Model.Entities.cliente;

@Component
public class clienteMapper {
  public clienteDto toClienteDto(cliente cliente){
    return clienteDto.builder()
    .email(cliente.getEmail())
    .dni(cliente.getDni())
    .numeroTelefono(cliente.getNumeroTelefono())
    .nombreCliente(cliente.getNombreCliente())
    .build();
  }
  public List<clienteDto> toClientesDto(List<cliente> clientes){
    return clientes.stream().map(this::toClienteDto).toList();
  }

  public cliente toCliente(clienteDto clienteDto){
    cliente cliente =new cliente();
    cliente.setEmail(clienteDto.getEmail());
    cliente.setDni(clienteDto.getDni());
    cliente.setNombreCliente(clienteDto.getNombreCliente());
    cliente.setNumeroTelefono(clienteDto.getNumeroTelefono());
    return cliente;
  }
}
