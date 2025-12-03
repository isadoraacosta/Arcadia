package com.ufg.trabalhoPOO.model.entidade;

import com.ufg.trabalhoPOO.model.dto.requisicao.RequestMetaDTO;
import jakarta.persistence.*;

@Entity
public class Meta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    private boolean concluida;


    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Meta(Usuario usuario1, Usuario usuario2, String pendente) {
    }

    public Meta(){
    }

    public Meta(String descricao, Usuario usuario) {
        this.descricao = descricao;
        this.usuario = usuario;
        this.concluida = false;
    }

    // Construtor usando DTO
    public Meta(RequestMetaDTO metaDTO, Usuario usuario) {
        this.descricao = metaDTO.getDescricao();
        this.usuario = usuario;
        this.concluida = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}