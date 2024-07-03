package com.api.api.Entidades.DTO;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class libroDTO {
    @NotBlank(message = "El titulo no puede estar en blanco")
    private String titulo;
    @NotBlank(message = "El nombre del autor no puede estar en blanco")
    private String autor;
    @NotBlank(message = "El genero no puede estar en blanco")
    private String genero;
    @NotNull(message = "El 'estado' debe estar definido")
    private boolean estado;
    
    
    

  

    

    
    

}
