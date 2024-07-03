package com.api.api.Entidades.DTO;
import lombok.Getter;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class personaDTO {
    @NotBlank(message = "Este campo no puede estar en blanco")
    private String nombre;
    
}
