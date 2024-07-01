package com.api.api.Entidades.DTO;

import jakarta.validation.constraints.NotNull;

public class prestamoDTO {
    @NotNull(message = "El id no puede estar en blanco")
   private Long idLibro;
    @NotNull(message = "El id no puede estar en blanco")
   private long idPersona;

   public prestamoDTO() {
   }

   public prestamoDTO(Long idLibro, long idPersona) {
    this.idLibro = idLibro;
    this.idPersona = idPersona;
    }

  public Long getIdLibro() {
       return idLibro;
   }
   
   public void setIdLibro(Long idLibro) {
       this.idLibro = idLibro;
   }
   
   public long getIdPersona() {
       return idPersona;
   }
   
   public void setIdPersona(long idPersona) {
       this.idPersona = idPersona;
   } 

    
}
