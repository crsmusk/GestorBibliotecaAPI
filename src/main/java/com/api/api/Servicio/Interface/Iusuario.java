package com.api.api.Servicio.Interface;

import com.api.api.Model.DTO.usuarioDto;

import java.util.List;

public interface Iusuario {
    public List<usuarioDto> findAll();
    public usuarioDto findById(Long id);
    public usuarioDto findByUserName(String userName);
    public void save (usuarioDto usuarioDto);
    public void update (Long id,usuarioDto usuarioDto);
    public void delete(Long id);
    public void changeRols(Long id,List<String>roles);
    public void changeUserName(Long id,String userName);
}
