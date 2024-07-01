package com.api.api.Entidades.Entities;
//import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToMany;


@Entity
public class prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @ManyToOne
 @JoinColumn(name="libro_id")
 libro libro;

 @ManyToOne
 @JoinColumn(name="persona_id")
 private persona persona;

  public Long getId() {
      return id;
  }
  
  public void setId(Long id) {
      this.id = id;
  }
  
  public libro getLibro() {
      return libro;
  }
  
  public void setLibro(libro libro) {
      this.libro = libro;
  }
  
  public persona getPersona() {
      return persona;
  }
  
  public void setPersona(persona persona) {
      this.persona = persona;
  }
   
}
