package com.ufg.trabalhoPOO.model.dto.resposta;

import com.ufg.trabalhoPOO.model.entidade.Avaliacao;

public class ResponseAvaliacaoDTO {
    private Long id;
    private Long usuarioId;
    private String livroIsbn;
    private int nota;
    private String comentario;

    public ResponseAvaliacaoDTO() {
    }

    public ResponseAvaliacaoDTO(Long id, Long usuarioId, String livroIsbn, int nota, String comentario) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.livroIsbn = livroIsbn;
        this.nota = nota;
        this.comentario = comentario;
    }

    public ResponseAvaliacaoDTO(Avaliacao avaliacao) {
        this.id = avaliacao.getId();
        this.usuarioId = avaliacao.getUsuario() != null ? avaliacao.getUsuario().getId() : null;
        this.livroIsbn = avaliacao.getLivro() != null ? avaliacao.getLivro().getIsbn() : null;
        this.nota = avaliacao.getNota();
        this.comentario = avaliacao.getComentario();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getLivroIsbn() {
        return livroIsbn;
    }

    public void setLivroIsbn(String livroIsbn) {
        this.livroIsbn = livroIsbn;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
