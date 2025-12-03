package com.ufg.trabalhoPOO.controller;

import com.ufg.trabalhoPOO.model.dto.requisicao.RequestMetaDTO;
import com.ufg.trabalhoPOO.model.dto.resposta.ResponseMetaDTO;
import com.ufg.trabalhoPOO.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metas")
@CrossOrigin("*")
public class MetaController {

    @Autowired
    private MetaService metaService;


    @PostMapping
    public ResponseEntity<ResponseMetaDTO> criarMeta(@RequestBody RequestMetaDTO metaDTO) {
        ResponseMetaDTO novaMeta = metaService.criarMeta(metaDTO);
        return ResponseEntity.ok(novaMeta);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<ResponseMetaDTO>> listarMetas(@PathVariable Long usuarioId) {
        List<ResponseMetaDTO> metas = metaService.listarMetasPorUsuario(usuarioId);
        return ResponseEntity.ok(metas);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<ResponseMetaDTO> alternarStatus(@PathVariable Long id) {
        ResponseMetaDTO metaAtualizada = metaService.alternarStatus(id);
        return ResponseEntity.ok(metaAtualizada);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMeta(@PathVariable Long id) {
        metaService.deletarMeta(id);
        return ResponseEntity.noContent().build();
    }
}