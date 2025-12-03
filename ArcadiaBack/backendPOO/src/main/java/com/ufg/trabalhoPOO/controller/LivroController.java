package com.ufg.trabalhoPOO.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufg.trabalhoPOO.model.dto.requisicao.RequestLivroDTO;
import com.ufg.trabalhoPOO.model.dto.resposta.ResponseLivroDTO;
import com.ufg.trabalhoPOO.model.entidade.Livro;
import com.ufg.trabalhoPOO.service.LivroService;

@RestController
@RequestMapping("/livros") // O endereço do site será /livros
@CrossOrigin("*")
public class LivroController {

    private LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    // Listar todos os livros
    @GetMapping
    public ResponseEntity<List<ResponseLivroDTO>> listarLivros() {
        return ResponseEntity.ok(livroService.listarLivros());
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<ResponseLivroDTO>> listarLivrosPorUsuario(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(livroService.listarLivrosPorUsuario(usuarioId));
    }

    // Cadastrar um novo livro
    @PostMapping
    public ResponseEntity<ResponseLivroDTO> cadastrarLivro(@RequestBody RequestLivroDTO livro) {
        ResponseLivroDTO criado = livroService.registrarLivro(livro);
        return ResponseEntity.ok(criado);
    }
}
