package com.api.api.Entidades.Entities;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String nombre;
 @OneToMany(mappedBy = "persona")
 List<prestamo>prestamo;
 public Long getId() {
     return id;
 }
 public void setId(Long id) {
     this.id = id;
 }
 public String getNombre() {
     return nombre;
 }
 public void setNombre(String nombre) {
     this.nombre = nombre;
 }
 
 
}
