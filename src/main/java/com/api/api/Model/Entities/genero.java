package com.api.api.Model.Entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
    @Column(name = "nombre_genero",unique = true)
  private String nombreGenero;
  @ManyToMany
  @JoinTable(
          name = "genero_libro",
          joinColumns = @JoinColumn(name = "genero_id"),
          inverseJoinColumns = @JoinColumn(name = "libro_id")
  )
  private List<libro>libros;
}
