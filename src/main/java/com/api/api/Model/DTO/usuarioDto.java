package com.api.api.Model.DTO;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class usuarioDto {
    private String username;
    private String password;
    private List<String> roles;
}
