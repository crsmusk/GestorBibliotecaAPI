package com.api.api.Servicio.Impl;

import com.api.api.Excepciones.Exceptions.noHayContenidoException;
import com.api.api.Excepciones.Exceptions.rolNoEncontradoException;
import com.api.api.Model.DTO.rolDto;
import com.api.api.Model.Entities.permiso;
import com.api.api.Model.Entities.rol;
import com.api.api.Repositorio.permisoRepository;
import com.api.api.Repositorio.rolRepository;
import com.api.api.Servicio.Interface.Irol;
import com.api.api.mapper.rolMapper;
import org.hibernate.dialect.function.ListaggStringAggEmulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class rolService implements Irol {

    @Autowired
    rolRepository rolRepo;
    @Autowired
    rolMapper mapper;
    @Autowired
    permisoRepository permisoRepo;

    @Override
    public List<rolDto> findAll() {
        List<rol>roles=rolRepo.findAll();
        if (roles.isEmpty()){
            throw new noHayContenidoException();
        }else{
            return mapper.rolesToRolesDto(roles);
        }

    }

    @Override
    public void save(rolDto rolDto) {
        rol rol=new rol();
        List<permiso>permisos=new ArrayList<>();
        for (String i:rolDto.getPermisos()){
            if (permisoRepo.findByNombrePermisoIgnoreCase(i).isPresent()){
                permisos.add(permisoRepo.findByNombrePermisoIgnoreCase(i).get());
            }else{
                throw new rolNoEncontradoException();
            }
        }
        rol.setPermisos(permisos);
        rol.setNombreRol(rolDto.getNombreRol().toUpperCase());
        rolRepo.save(rol);
    }

    @Override
    public void delete(Long id) {
         if (rolRepo.existsById(id)){
             rolRepo.deleteById(id);
         }else{
             throw new rolNoEncontradoException();
         }
    }

    @Override
    public void update(Long id, rolDto rolDto) {
        rol rol=rolRepo.findById(id).orElseThrow(()->new rolNoEncontradoException());
        rol.setNombreRol(rolDto.getNombreRol());
        List<permiso>permisos=new ArrayList<>();
        for (String i:rolDto.getPermisos()){
            if (permisoRepo.findByNombrePermisoIgnoreCase(i).isPresent()){
                permisos.add(permisoRepo.findByNombrePermisoIgnoreCase(i).get());
            }else{
                throw new rolNoEncontradoException();
            }
        }
        rol.setPermisos(permisos);
        rolRepo.save(rol);
    }

    @Override
    public rolDto findById(Long id) {
        Optional<rol>rol=rolRepo.findById(id);
        if (rol.isPresent()){
            return mapper.rolToRolDto(rol.get());
        }else{
            throw new rolNoEncontradoException();
        }
    }

    @Override
    public rolDto findByNameRol(String nombreRol) {
        Optional<rol>rol=rolRepo.findByNombreRolIgnoreCase(nombreRol);
        if (rol.isPresent()){
            return mapper.rolToRolDto(rol.get());
        }else{
            throw new rolNoEncontradoException();
        }
    }

    @Override
    public void changePermissions(Long id, List<String> permisos) {
        rol rol=rolRepo.findById(id).orElseThrow(()->new rolNoEncontradoException());
        List<permiso>permiso=new ArrayList<>();
        for (String i:permisos){
            if (permisoRepo.findByNombrePermisoIgnoreCase(i).isPresent()){
                permiso.add(permisoRepo.findByNombrePermisoIgnoreCase(i).get());
            }else{
                throw new rolNoEncontradoException();
            }
        }
        rol.setPermisos(permiso);
        rolRepo.save(rol);
    }
}
