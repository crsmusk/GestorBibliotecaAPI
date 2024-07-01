package com.api.api.Entidades.DTO;

import jakarta.validation.constraints.NotBlank;

public class personaDTO {
    @NotBlank(message = "Este campo no puede estar en blanco")
    private String nombre;
    
    
    public personaDTO() {
    }

    public personaDTO(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
