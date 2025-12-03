package com.ufg.trabalhoPOO.service;

import com.ufg.trabalhoPOO.model.dto.requisicao.RequestMetaDTO;
import com.ufg.trabalhoPOO.model.dto.resposta.ResponseMetaDTO;
import com.ufg.trabalhoPOO.model.entidade.Meta;
import com.ufg.trabalhoPOO.model.entidade.Usuario;
import com.ufg.trabalhoPOO.repository.MetaRepository;
import com.ufg.trabalhoPOO.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MetaService {

    @Autowired
    private MetaRepository metaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResponseMetaDTO criarMeta(RequestMetaDTO metaDTO) {
        Usuario usuario = usuarioRepository.findById(metaDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Meta novaMeta = new Meta(metaDTO, usuario);
        Meta metaSalva = metaRepository.save(novaMeta);

        return new ResponseMetaDTO(metaSalva);
    }

    public List<ResponseMetaDTO> listarMetasPorUsuario(Long usuarioId) {
        List<Meta> metas = metaRepository.findByUsuarioId(usuarioId);

        return metas.stream()
                .map(ResponseMetaDTO::new)
                .collect(Collectors.toList());
    }

    public ResponseMetaDTO alternarStatus(Long metaId) {
        Meta meta = metaRepository.findById(metaId)
                .orElseThrow(() -> new RuntimeException("Meta não encontrada"));

        meta.setConcluida(!meta.isConcluida()); // Inverte o valor
        Meta metaAtualizada = metaRepository.save(meta);

        return new ResponseMetaDTO(metaAtualizada);
    }

    public void deletarMeta(Long metaId) {
        if (!metaRepository.existsById(metaId)) {
            throw new RuntimeException("Meta não encontrada");
        }
        metaRepository.deleteById(metaId);
    }
}