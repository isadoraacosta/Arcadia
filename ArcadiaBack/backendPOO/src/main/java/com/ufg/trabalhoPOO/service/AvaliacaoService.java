package com.ufg.trabalhoPOO.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ufg.trabalhoPOO.model.dto.requisicao.RequestAvaliacaoDTO;
import com.ufg.trabalhoPOO.model.dto.resposta.ResponseAvaliacaoDTO;
import com.ufg.trabalhoPOO.model.entidade.Avaliacao;
import com.ufg.trabalhoPOO.model.entidade.Livro;
import com.ufg.trabalhoPOO.model.entidade.Usuario;
import com.ufg.trabalhoPOO.repository.AvaliacaoRepository;
import com.ufg.trabalhoPOO.repository.LivroRepository;
import com.ufg.trabalhoPOO.repository.UsuarioRepository;

@Service
public class AvaliacaoService {
    private AvaliacaoRepository avaliacaoRepository;
    private UsuarioRepository usuarioRepository;
    private LivroRepository livroRepository;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository, UsuarioRepository usuarioRepository, LivroRepository livroRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
        this.usuarioRepository = usuarioRepository;
        this.livroRepository = livroRepository;
    }

    public ResponseAvaliacaoDTO criarAvaliacao(RequestAvaliacaoDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Livro livro = livroRepository.findByIsbn(dto.getLivroIsbn()).orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        Avaliacao avaliacao = new Avaliacao(usuario, livro, dto.getNota(), dto.getComentario());
        Avaliacao salvo = avaliacaoRepository.save(avaliacao);
        return new ResponseAvaliacaoDTO(salvo);
    }

    public List<Avaliacao> listarAvaliacoes() {
        return avaliacaoRepository.findAll();
    }
}
