package com.api.api.Model.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
  @OneToMany(mappedBy = "genero")
  private List<libro>libros;
}
