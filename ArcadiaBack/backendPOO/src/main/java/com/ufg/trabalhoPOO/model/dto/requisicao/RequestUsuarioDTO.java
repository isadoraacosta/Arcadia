package com.ufg.trabalhoPOO.model.dto.requisicao;

import com.ufg.trabalhoPOO.model.entidade.Usuario;

public class RequestUsuarioDTO {
    private String nome;
    private String email;
    private String senha;

    public RequestUsuarioDTO(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public RequestUsuarioDTO() {
    }

    public RequestUsuarioDTO(Usuario usuario) {
        this.nome = usuario.getNome();
        this.senha = usuario.getSenha();
        this.email = usuario.getEmail();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
