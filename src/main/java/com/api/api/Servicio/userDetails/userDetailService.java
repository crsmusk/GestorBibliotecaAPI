package com.api.api.Servicio.userDetails;

import com.api.api.Excepciones.Exceptions.usuarioNoEncontradoException;
import com.api.api.Model.Entities.usuario;
import com.api.api.Repositorio.usuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class userDetailService implements UserDetailsService {
    @Autowired
    usuarioRepository usuarioRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        usuario usuario=usuarioRepo.findByUserNameIgnoreCase(username).orElseThrow(()->new usuarioNoEncontradoException());

        List<SimpleGrantedAuthority>lista=new ArrayList<>();

        usuario.getRoles().forEach(rol->lista.add(new SimpleGrantedAuthority("ROLE_".concat(rol.getNombreRol()))));

        usuario.getRoles().stream().flatMap(rol->rol.getPermisos().stream()).forEach(permiso->lista.add(new SimpleGrantedAuthority(permiso.getNombrePermiso())));

        return new User(usuario.getUserName(),usuario.getPassword()
                ,usuario.isEnable(),usuario.isAccountNoExpired(),
                usuario.isCredentialNoExpired(),usuario.isAccountNoLocked(),lista);
    }
}
