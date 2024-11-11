package com.api.api.Servicio.Impl;

import com.api.api.Excepciones.Exceptions.noHayContenidoException;
import com.api.api.Excepciones.Exceptions.rolNoEncontradoException;
import com.api.api.Excepciones.Exceptions.usuarioNoEncontradoException;
import com.api.api.Model.DTO.usuarioDto;
import com.api.api.Model.Entities.rol;
import com.api.api.Model.Entities.usuario;
import com.api.api.Repositorio.rolRepository;
import com.api.api.Repositorio.usuarioRepository;
import com.api.api.Servicio.Interface.Iusuario;
import com.api.api.mapper.usuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class usuarioService implements Iusuario {

    @Autowired
    usuarioRepository usuarioRepos;
    @Autowired
    usuarioMapper mapper;
    @Autowired
    rolRepository rolRepo;


    @Override
    public List<usuarioDto> findAll() {
        List<usuario>usuarios=usuarioRepos.findAll();
        if (usuarios.isEmpty()){
            throw new noHayContenidoException();
        }else{
            return mapper.usuariosToUsuariosDto(usuarios);
        }
    }

    @Override
    public usuarioDto findById(Long id) {
        Optional<usuario>usuario=usuarioRepos.findById(id);
        if (usuario.isPresent()){
            return mapper.usuarioToUsuarioDto(usuario.get());
        }else{
            throw new usuarioNoEncontradoException();
        }
    }

    @Override
    public usuarioDto findByUserName(String userName) {
        Optional<usuario>usuario=usuarioRepos.findByUserNameIgnoreCase(userName);
        if (usuario.isPresent()){
            return mapper.usuarioToUsuarioDto(usuario.get());
        }else{
            throw new usuarioNoEncontradoException();
        }
    }

    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void save(usuarioDto usuarioDto) {
        usuario usuario=new usuario();
        usuario.setUserName(usuarioDto.getUsername());
        usuario.setPassword(usuarioDto.getPassword());
        List<rol>roles=new ArrayList<>();
        for (String i:usuarioDto.getRoles()){
            if (rolRepo.findByNombreRolIgnoreCase(i).isPresent()){
                roles.add(rolRepo.findByNombreRolIgnoreCase(i).get());
            }else{
                throw new rolNoEncontradoException();
            }
        }
        usuario.setRoles(roles);
        usuarioRepos.save(usuario);
    }

    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void update(Long id, usuarioDto usuarioDto) {
       usuario usuario=usuarioRepos.findById(id).orElseThrow(()->new usuarioNoEncontradoException());
       usuario.setPassword(usuarioDto.getPassword());
       usuario.setUserName(usuarioDto.getUsername());
       List<rol>roles=new ArrayList<>();
       for (String i:usuarioDto.getRoles()){
           if (rolRepo.findByNombreRolIgnoreCase(i).isPresent()){
               roles.add(rolRepo.findByNombreRolIgnoreCase(i).get());
           }else{
               throw new rolNoEncontradoException();
           }
       }
       usuario.setRoles(roles);
       usuarioRepos.save(usuario);
    }

    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void delete(Long id) {
        if (usuarioRepos.existsById(id)){
            usuarioRepos.deleteById(id);
        }else{
            throw new usuarioNoEncontradoException();
        }
    }

    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void changeRols(Long id, List<String> roles) {
        Optional<usuario>usuario=usuarioRepos.findById(id);
        List<rol>rols=new ArrayList<>();
        if (usuario.isPresent()){
            for (String i:roles){
                if (rolRepo.findByNombreRolIgnoreCase(i).isPresent()){
                    rols.add(rolRepo.findByNombreRolIgnoreCase(i).get());
                }else{
                    throw new rolNoEncontradoException();
                }
            }
        }else{
            throw new usuarioNoEncontradoException();
        }
        usuario.get().setRoles(rols);
        usuarioRepos.save(usuario.get());
    }

    @Override
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void changeUserName(Long id,String userName) {
          Optional<usuario>usuario=usuarioRepos.findById(id);
          if (usuario.isPresent()){
              usuario.get().setUserName(userName);
              usuarioRepos.save(usuario.get());
          }else{
              throw new usuarioNoEncontradoException();
          }
    }
}
