package com.api.api.Model.DTO;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class rolDto {
    private Long id;
    private String nombreRol;
    private List<String> permisos;
}
