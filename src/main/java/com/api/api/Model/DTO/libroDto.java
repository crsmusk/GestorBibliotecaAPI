package com.api.api.Model.DTO;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
public class libroDto {
    private String titulo;
    private boolean estado;
    private String nombreAutor;
    private List<String> nombreGenero;
    
}
