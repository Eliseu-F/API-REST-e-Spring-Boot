package com.eliseu.demo_park_api.web.dto;

import lombok.*;

//lombok
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class UsuarioSenhaDto {
    
    private String senhaAtual;
    private String novaSenha;
    private String confirmaSenha;
}
