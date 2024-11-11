package com.api.api.Servicio.Impl;

import com.api.api.Excepciones.Exceptions.noHayContenidoException;
import com.api.api.Excepciones.Exceptions.permisoNoEncontradoException;
import com.api.api.Excepciones.Exceptions.usuarioNoEncontradoException;
import com.api.api.Model.DTO.permisoDto;
import com.api.api.Model.Entities.permiso;
import com.api.api.Repositorio.permisoRepository;
import com.api.api.Servicio.Interface.Ipermiso;
import com.api.api.mapper.permisoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class permisoService implements Ipermiso {

    @Autowired
    permisoRepository permisoRepo;
    @Autowired
    permisoMapper mapper;


    @Override
    public List<permisoDto> findAll() {

        List<permiso>permisos=permisoRepo.findAll();
        if (permisos.isEmpty()){
            throw  new noHayContenidoException();
        }else{
            return mapper.toPermisoToPermisosDto(permisos);
        }

    }

    @Override
    public permisoDto findById(Long id) {
        Optional<permiso>permiso=permisoRepo.findById(id);
        if (permiso.isPresent()){
            return mapper.permisoToPermisoDto(permiso.get());
        }else{
            throw new permisoNoEncontradoException();
        }
    }

    @Override
    public permisoDto findByName(String nombre) {
        Optional<permiso>permiso=permisoRepo.findByNombrePermisoIgnoreCase(nombre);
        if (permiso.isPresent()){
            return mapper.permisoToPermisoDto(permiso.get());
        }else{
            throw new permisoNoEncontradoException();
        }
    }

    @Override
    public void save(permisoDto permisoDto) {
       permiso permiso=new permiso();
       permiso.setNombrePermiso(permisoDto.getNombrePermiso().toUpperCase());
       permisoRepo.save(permiso);
    }

    @Override
    public void update(Long id, permisoDto permisoDto) {
       Optional<permiso>permiso=permisoRepo.findById(id);
       if (permiso.isPresent()){
           permiso.get().setNombrePermiso(permisoDto.getNombrePermiso());
           permisoRepo.save(permiso.get());
       }else{
           throw new permisoNoEncontradoException();
       }
    }

    @Override
    public void delete(Long id) {
      if (permisoRepo.existsById(id)){
          permisoRepo.deleteById(id);
      }else{
          throw new permisoNoEncontradoException();
      }
    }
}
