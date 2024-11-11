package com.api.api.mapper;


import com.api.api.Model.DTO.rolDto;
import com.api.api.Model.Entities.rol;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class rolMapper {

    public rolDto rolToRolDto(rol rol){
        rolDto rolDt=rolDto.builder()
                .nombreRol(rol.getNombreRol())
                .id(rol.getId())
                .permisos(rol.getPermisos().stream().map(role->role.getNombrePermiso()).toList())
                .build();
        return rolDt;
    }
    public List<rolDto>rolesToRolesDto(List<rol>roles){
        return roles.stream().map(this::rolToRolDto).toList();
    }
}
