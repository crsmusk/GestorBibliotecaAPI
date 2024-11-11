package com.api.api.Servicio.Interface;

import com.api.api.Model.DTO.permisoDto;

import java.util.List;

public interface Ipermiso {
    public List<permisoDto>findAll();
    public permisoDto findById(Long id);
    public permisoDto findByName(String nombre);
    public void save (permisoDto permisoDto);
    public void update (Long id,permisoDto permisoDto);
    public void delete(Long id);
}
