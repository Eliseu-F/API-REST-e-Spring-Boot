package com.eliseu.demo_park_api.web.dto;

import lombok.*;

//lombok
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class UsuarioResponseDto {
    
    //resposta da API - Será mostrado no postman
    private Long id;
    private String username;
    private String role;
}
