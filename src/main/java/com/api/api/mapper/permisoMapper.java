package com.api.api.mapper;

import com.api.api.Model.DTO.permisoDto;
import com.api.api.Model.Entities.permiso;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class permisoMapper {

    public permisoDto permisoToPermisoDto(permiso permiso){
        permisoDto permisoDt= permisoDto.builder()
                .nombrePermiso(permiso.getNombrePermiso())
                .build();
        return permisoDt;
    }
    public List<permisoDto>toPermisoToPermisosDto(List<permiso>permisos){
        return permisos.stream().map(this::permisoToPermisoDto).toList();
    }
}
