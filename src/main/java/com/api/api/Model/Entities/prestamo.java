package com.api.api.Model.Entities;
import java.time.LocalDate;
import java.util.List;

//import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
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
    private boolean estadoPrestamo;
 @OneToMany(mappedBy = "prestamo",cascade = CascadeType.MERGE)
 List<libro>libros;
 @ManyToOne
 @JoinColumn(name="persona_id")
 private cliente cliente;

  
}
