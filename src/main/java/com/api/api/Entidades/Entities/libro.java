package com.api.api.Entidades.Entities;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;

@Entity
public class libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String titulo;
 private String autor;
 private String genero;
 private boolean estado;
 @OneToMany(mappedBy = "libro")
 private List<prestamo> prestamo;
  public Long getId() {
      return id;
  }
  public void setId(Long id) {
      this.id = id;
  }
  public String getTitulo() {
      return titulo;
  }
  public void setTitulo(String titulo) {
      this.titulo = titulo;
  }
  public String getAutor() {
      return autor;
  }
  public void setAutor(String autor) {
      this.autor = autor;
  }
  public String getGenero() {
      return genero;
  }
  public void setGenero(String genero) {
      this.genero = genero;
  }
  public boolean isEstado() {
      return estado;
  }
  public void setEstado(boolean estado) {
      this.estado = estado;
  }

 

}
