package com.mballem.tarefas.web.controller;

import com.mballem.internal.entity.Contato;
import com.mballem.internal.service.ContatoService;
import lombok.RequiredArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tarefas/contatos")
public class ContatoController {
    private final ContatoService contatoService;

    //http://localhost:8080/tarefas/contatos
    //EXERCICIO 1
    @PostMapping
    public ResponseEntity<Contato> create(@RequestBody Contato contato) {
        Contato contato1 = contatoService.save(contato);
        return ResponseEntity.status(HttpStatus.CREATED).body(contato1);
    }

    //http://localhost:8080/tarefas/contatos/23    
    //EXERCICIO 2
    @GetMapping("/{id}")
    public ResponseEntity<Contato> getById(@PathVariable Long id) {
        Contato contato1 = contatoService.getById(id);
        return ResponseEntity.ok(contato1);
    }

    //http://localhost:8080/tarefas/contatos/nome/Juliana Madeira
    // EXERCICIO 3
    @GetMapping("/nome/{nome}")
    public ResponseEntity<Contato> getContatoByNome(@PathVariable String nome) {
        Contato contato1 = contatoService.getContatoByNome(nome);
        return ResponseEntity.ok(contato1);
    }

    //http://localhost:8080/tarefas/contatos/quantidade
    // EXERCICIO 4
    @GetMapping("/quantidade")
    public ResponseEntity<Long> getQuantidadeDeContatos() {
        long quantidade = contatoService.getAll();
        return new ResponseEntity<>(quantidade, HttpStatus.OK);
    }

    //http://localhost:8080/tarefas/contatos/data/1996-10-01
    // EXERCICIO 5
    @GetMapping("/data/{data}")
    public ResponseEntity<List<Contato>> getContatosByDataNascimento(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        List <Contato> contato1 = contatoService.getByDataNascimento(data);
        return ResponseEntity.ok(contato1);
    }

    //http://localhost:8080/tarefas/contatos/28
    // EXERCICIO 6
    @PatchMapping("/{id}")
    public ResponseEntity<Contato> updateContatoById(@PathVariable Long id,  @RequestBody Contato contato) {
        Contato newContato = contatoService.update(id, contato);
        return ResponseEntity.ok(newContato);
    }
    //http://localhost:8080/tarefas/contatos/32
    // EXERCICIO 7
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        String contato = contatoService.delete(id);
        return ResponseEntity.ok(contato);
    }
}
