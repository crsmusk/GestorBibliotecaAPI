package com.api.api.Model.Entities;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "libros")
public class libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String titulo;
 private boolean estado;
 @ManyToOne
 @JoinColumn(name = "prestamo_id")
 private prestamo prestamo;
 @ManyToOne
 @JoinColumn(name = "autor_id")
 private autor autor;
 @ManyToMany
 private List<genero> genero;
 
 

}
