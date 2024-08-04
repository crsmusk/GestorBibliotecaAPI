package com.api.api.Model.DTO;

import java.time.LocalDate;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class prestamoDto {
   private LocalDate fechaDePrestamo;
   private LocalDate fechaDeEntrega;
   private libroDto libroDto;
   private personaDto personaDto;

}
