package com.api.api.Model.DTO;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class clienteDto {
    private String email;
    private String nombreCliente;
    private String numeroTelefono;
    private LocalDate añoMembresia=LocalDate.now();
    private String dni;
}
