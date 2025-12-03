package com.ufg.trabalhoPOO.controller;

import com.ufg.trabalhoPOO.model.dto.requisicao.LoginUsuarioDTO;
import com.ufg.trabalhoPOO.model.dto.requisicao.RequestUsuarioDTO;
import com.ufg.trabalhoPOO.model.dto.resposta.ResponseUsuarioDTO;
import com.ufg.trabalhoPOO.model.entidade.Usuario;
import com.ufg.trabalhoPOO.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; // <--- Importante para status HTTP (200, 401)
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodos() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }


    //cadastrar o usuario com base na solicitação do front
    @PostMapping("/cadastrar")
    public ResponseEntity<ResponseUsuarioDTO> criarUsuario(@RequestBody RequestUsuarioDTO usuario) {
        ResponseUsuarioDTO usuarioCriado = usuarioService.registrarUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCriado);
    }

    //verifica se o usuario existe e faz login
    @PostMapping("/login")
    public ResponseEntity<ResponseUsuarioDTO> login(@RequestBody LoginUsuarioDTO dadosLogin) {
        ResponseUsuarioDTO login = usuarioService.login(dadosLogin);
        return ResponseEntity.ok(login);
    }
}