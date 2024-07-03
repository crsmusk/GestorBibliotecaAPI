package com.api.api.Entidades.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class prestamoDTO {
    @NotNull(message = "El id no puede estar en blanco")
   private Long idLibro;
    @NotNull(message = "El id no puede estar en blanco")
   private long idPersona;

}
