package com.ufg.trabalhoPOO.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ufg.trabalhoPOO.model.dto.requisicao.RequestAvaliacaoDTO;
import com.ufg.trabalhoPOO.model.dto.resposta.ResponseAvaliacaoDTO;
import com.ufg.trabalhoPOO.model.entidade.Avaliacao;
import com.ufg.trabalhoPOO.service.AvaliacaoService;

@RestController
@RequestMapping("/avaliacoes")
@CrossOrigin("*")
public class AvaliacaoController {

    private AvaliacaoService avaliacaoService;

    public AvaliacaoController(AvaliacaoService avaliacaoService) {
        this.avaliacaoService = avaliacaoService;
    }
    // Listar todas as avaliações
    @GetMapping
    public ResponseEntity<List<Avaliacao>> listarAvaliacoes() {
        return ResponseEntity.ok(avaliacaoService.listarAvaliacoes());
    }

    // Criar uma nova avaliação
    @PostMapping
    public ResponseEntity<ResponseAvaliacaoDTO> criarAvaliacao(@RequestBody RequestAvaliacaoDTO avaliacao) {
        ResponseAvaliacaoDTO criado = avaliacaoService.criarAvaliacao(avaliacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

}
