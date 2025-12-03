package com.ufg.trabalhoPOO.model.dto.requisicao;

public class RequestAvaliacaoDTO {
    private Long usuarioId;
    private String livroIsbn;
    private int nota;
    private String comentario;

    public RequestAvaliacaoDTO() {
    }

    public RequestAvaliacaoDTO(Long usuarioId, String livroIsbn, int nota, String comentario) {
        this.usuarioId = usuarioId;
        this.livroIsbn = livroIsbn;
        this.nota = nota;
        this.comentario = comentario;
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
