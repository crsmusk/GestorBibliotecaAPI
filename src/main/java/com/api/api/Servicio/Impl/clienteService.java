package com.api.api.Servicio.Impl;
import java.util.List;

import com.api.api.Excepciones.Exceptions.noHayContenidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.api.Excepciones.Exceptions.personaException;
import com.api.api.Model.DTO.clienteDto;
import com.api.api.Model.Entities.cliente;
import com.api.api.Repositorio.clienteRepository;
import com.api.api.Servicio.Interface.Icliente;
import com.api.api.mapper.clienteMapper;

@Service
public class clienteService implements Icliente {
   @Autowired
   private clienteRepository personaRepo;
   @Autowired
   private clienteMapper mapper;

   @Override
   public List<clienteDto> findAll(){
      List<cliente>clientes=personaRepo.findAll();
      if (clientes.isEmpty()) {
         throw new noHayContenidoException();
      }
      
      return mapper.toClientesDto(clientes);
   }

   @Override
   public clienteDto findById(Long id) {
      cliente perso=personaRepo.findById(id).orElseThrow(()-> new personaException("no se encontro ala persona"));
      clienteDto persona=mapper.toClienteDto(perso);
     return persona;
   }

   @Override
   public void save(clienteDto clienteDto) {
      personaRepo.save(mapper.toCliente(clienteDto));
   }

   @Override
   public void deleteById(Long id) {
      if (personaRepo.existsById(id)) {
          personaRepo.deleteById(id);
      }else{
         throw new personaException("no se encontro el usuario con el id"+id);
      }
    
   }

   @Override
   public clienteDto findByEmail(String email) {
     cliente perso=personaRepo.findByEmail(email).orElseThrow(()-> new personaException("no se econtro ala persona con el email:"+email));
     clienteDto persona=mapper.toClienteDto(perso);
     return persona;
   }
   
   @Override
   public void update(Long id, clienteDto clienteDTO) {
      cliente cliente =personaRepo.findById(id).orElseThrow(()-> new personaException("no se econtro ala persona con el id"+id));
      cliente.setEmail(clienteDTO.getEmail());
      cliente.setDni(clienteDTO.getDni());
      cliente.setNumeroTelefono(clienteDTO.getNumeroTelefono());
      personaRepo.save(cliente);
   }

  

}
