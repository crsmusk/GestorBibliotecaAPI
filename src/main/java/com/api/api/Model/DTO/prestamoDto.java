package com.api.api.Model.DTO;

import java.time.LocalDate;

import com.api.api.Model.Entities.libro;
import com.api.api.Model.Entities.persona;

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
public class prestamoDto {

   private LocalDate fechaDePrestamo;
   private LocalDate fechaDeEntrega;
   private libro libro;
   private persona persona ;

}
