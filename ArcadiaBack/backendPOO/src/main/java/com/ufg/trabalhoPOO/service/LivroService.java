package com.ufg.trabalhoPOO.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Service;

import com.ufg.trabalhoPOO.model.dto.requisicao.RequestLivroDTO;
import com.ufg.trabalhoPOO.model.dto.resposta.ResponseLivroDTO;
import com.ufg.trabalhoPOO.model.entidade.Livro;
import com.ufg.trabalhoPOO.model.entidade.Usuario;
import com.ufg.trabalhoPOO.repository.LivroRepository;
import com.ufg.trabalhoPOO.repository.UsuarioRepository;

@Service
public class LivroService {
    private LivroRepository livroRepository;
    private UsuarioRepository usuarioRepository;

    public LivroService(LivroRepository livroRepository, UsuarioRepository usuarioRepository) {
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public ResponseLivroDTO registrarLivro(RequestLivroDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado para id " + dto.getUsuarioId()));

        Livro livro = new Livro(dto.getIsbn(), dto.getTitulo(), dto.getAutor(), dto.getGenero(), dto.getAno(), usuario);
        Livro salvo = livroRepository.save(livro);
        return new ResponseLivroDTO(salvo);
    }

    public List<ResponseLivroDTO> listarLivros() {
        return livroRepository.findAll()
                .stream()
                .map(ResponseLivroDTO::new)
                .collect(Collectors.toList());
    }

    public List<ResponseLivroDTO> listarLivrosPorUsuario(Long usuarioId) {
        usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado para id " + usuarioId));

        return livroRepository.findByUsuarioId(usuarioId)
                .stream()
                .map(ResponseLivroDTO::new) // Converte cada Livro para DTO
                .collect(Collectors.toList());
    }
}
