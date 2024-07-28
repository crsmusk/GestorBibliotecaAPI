package com.api.api.Model.DTO;
import com.api.api.Model.Entities.autor;
import com.api.api.Model.Entities.genero;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
public class libroDto {
    private String titulo;
    private boolean estado;
    private autor autor;
    private genero genero; 
}