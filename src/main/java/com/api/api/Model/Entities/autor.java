package com.api.api.Model.Entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "autores")
public class autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nombre;
  @OneToMany(mappedBy = "autor")
  List<libro>libros;
}
