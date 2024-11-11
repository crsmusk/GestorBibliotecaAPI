package com.api.api.Servicio.Interface;

import com.api.api.Model.DTO.rolDto;

import java.util.List;

public interface Irol {
    public List<rolDto> findAll();
    public void save(rolDto rolDto);
    public void delete(Long id);
    public void update(Long id,rolDto rolDto);
    public rolDto findById(Long id);
    public rolDto findByNameRol(String nombreRol);
    public void changePermissions(Long id,List<String>permisos);
}
