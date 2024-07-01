package com.api.api.Entidades.DTO;
import jakarta.validation.constraints.*;



public class libroDTO {
    @NotBlank(message = "El titulo no puede estar en blanco")
    private String titulo;
    @NotBlank(message = "El nombre del autor no puede estar en blanco")
    private String autor;
    @NotBlank(message = "El genero no puede estar en blanco")
    private String genero;
    @NotNull(message = "El 'estado' debe estar definido")
    private boolean estado;
    
    public libroDTO() {
    }

    public libroDTO(String titulo, String autor, String genero, boolean estado) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.estado = estado;
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
