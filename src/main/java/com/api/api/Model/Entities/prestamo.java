package com.api.api.Model.Entities;
import java.time.LocalDate;

//import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
//import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prestamos")
public class prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
    private LocalDate fechaDePrestamo;
    private LocalDate fechaDeEntrega;
 @ManyToOne
 @JoinColumn(name="libro_id")
 libro libro;
 
 @ManyToOne
 @JoinColumn(name="persona_id")
 private persona persona;

  
}
