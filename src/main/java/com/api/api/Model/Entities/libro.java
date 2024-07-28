package com.api.api.Model.Entities;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import jakarta.persistence.OneToOne;
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
 @OneToMany(mappedBy = "libro")
 private List<prestamo> prestamo;
 @ManyToOne
 @JoinColumn(name = "autor_id")
 private autor autor;
 @ManyToOne
 @JoinColumn(name = "genero_id")
 private genero genero;
 
 

}
