package com.ufg.trabalhoPOO.model.entidade;

import com.ufg.trabalhoPOO.model.dto.requisicao.RequestUsuarioDTO;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity //Entidade do banco de dados
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O banco gera o ID (1, 2, 3...)
    private Long id;

    private String nome;

    @Column(unique = true) // não permite emails repetidos
    private String email;

    private String senha;

    // Um usuário pode ter muitas avaliações

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Avaliacao> avaliacoes;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Livro> livros;

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    public Usuario() {
        
    }

    public Usuario(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(RequestUsuarioDTO usuarioDTO) {
        this.nome = usuarioDTO.getNome();
        this.email = usuarioDTO.getEmail();
        this.senha = usuarioDTO.getSenha();
    }


    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public List<Avaliacao> getAvaliacoes() { 
        return avaliacoes; 
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) { 
        this.avaliacoes = avaliacoes; 
    }

}
