package com.api.api.mapper;

import com.api.api.Model.DTO.usuarioDto;
import com.api.api.Model.Entities.rol;
import com.api.api.Model.Entities.usuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class usuarioMapper {
    public usuarioDto usuarioToUsuarioDto(usuario usuario){
        usuarioDto usuarioDt=usuarioDto.builder()
                .username(usuario.getUserName())
                .password(usuario.getPassword())
                .roles(usuario.getRoles().stream().map(rol->rol.getNombreRol()).toList())
                .build();
        return usuarioDt;
    }

    public List<usuarioDto>usuariosToUsuariosDto(List<usuario>usuarios){
        return usuarios.stream().map(this::usuarioToUsuarioDto).toList();
    }
}
