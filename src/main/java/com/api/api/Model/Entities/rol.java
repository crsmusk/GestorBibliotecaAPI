package com.api.api.Model.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_rol")
    private String nombreRol;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinTable(name = "rol_permiso",joinColumns =
    @JoinColumn(name = "rol_id"),inverseJoinColumns =
    @JoinColumn(name = "permiso_id"))
    private List<permiso>permisos;
}
