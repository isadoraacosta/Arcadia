package com.ufg.trabalhoPOO.model.dto.resposta;

import com.ufg.trabalhoPOO.model.entidade.Meta;

public class ResponseMetaDTO {

    private Long id;
    private String descricao;
    private Boolean concluida;

    public ResponseMetaDTO(Meta meta) {
        this.id = meta.getId();
        this.descricao = meta.getDescricao();
        this.concluida = meta.isConcluida();
    }
    public ResponseMetaDTO() {}


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Boolean getConcluida() { return concluida; }
    public void setConcluida(Boolean concluida) { this.concluida = concluida; }
}