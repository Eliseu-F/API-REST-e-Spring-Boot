package com.eliseu.demo_park_api.web.controller;

import com.eliseu.demo_park_api.entity.Usuario;
import com.eliseu.demo_park_api.service.UsuarioService;
import com.eliseu.demo_park_api.web.dto.UsuarioCreateDto;
import com.eliseu.demo_park_api.web.dto.UsuarioResponseDto;
import com.eliseu.demo_park_api.web.dto.mapper.UsuarioMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor // Lombok irá gerar um construtor com os campos final
@RestController // Define que esta classe é um controlador REST
@RequestMapping("api/v1/usuarios") // Define a URL base para os endpoints desta classe
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> create(@RequestBody UsuarioCreateDto createDto){
        Usuario user = usuarioService.salvar(UsuarioMapper.toUsuario(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> getById(@PathVariable Long id){
        Usuario user = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(UsuarioMapper.toDto(user));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> updatePassword(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario user = usuarioService.editarSenha(id, usuario.getPassword());
        return ResponseEntity.ok(UsuarioMapper.toDto(user));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll(){
        List <Usuario> users = usuarioService.buscarTodos();
        return ResponseEntity.ok(users);
    }
}
