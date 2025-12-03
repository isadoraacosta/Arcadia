package com.ufg.trabalhoPOO.model.dto.requisicao;

public class LoginUsuarioDTO {
    private String email;
    private String senha;

    public LoginUsuarioDTO(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public LoginUsuarioDTO() {
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
