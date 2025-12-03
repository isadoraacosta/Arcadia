package com.ufg.trabalhoPOO.model.dto.requisicao;

public class RequestMetaDTO {

    private String descricao;

    private Long usuarioId; // Precisamos saber de quem é a meta

    public RequestMetaDTO() {
    }

    public RequestMetaDTO(String descricao, Long usuarioId) {
        this.descricao = descricao;
        this.usuarioId = usuarioId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}