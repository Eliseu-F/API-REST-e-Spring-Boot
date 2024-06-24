package com.eliseu.demo_park_api.web.dto;

import lombok.*;

//lombok
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class UsuarioResponseDto {
    
    private Long id;
    private String username;
    private String role;
}
