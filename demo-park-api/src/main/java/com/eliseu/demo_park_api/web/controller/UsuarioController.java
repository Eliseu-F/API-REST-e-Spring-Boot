package com.eliseu.demo_park_api.web.controller;

import com.eliseu.demo_park_api.entity.Usuario;
import com.eliseu.demo_park_api.service.UsuarioService;
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
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
        Usuario user = usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id){
        Usuario user = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(user);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> updatePassword(@PathVariable Long id, @RequestBody Usuario usuario){
        Usuario user = usuarioService.editarSenha(id, usuario.getPassword());
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll(){
        List <Usuario> users = usuarioService.buscarTodos();
        return ResponseEntity.ok(users);
    }
}
