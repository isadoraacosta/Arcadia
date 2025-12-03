package com.ufg.trabalhoPOO.model.dto.resposta;

import com.ufg.trabalhoPOO.model.entidade.Livro;

public class ResponseLivroDTO {
    private String isbn;
    private String titulo;
    private String autor;
    private String genero;
    private int ano;

    public ResponseLivroDTO() {
    }

    public ResponseLivroDTO(String isbn, String titulo, String autor, String genero, int ano) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.ano = ano;
    }

    public ResponseLivroDTO(Livro livro) {
        this.isbn = livro.getIsbn();
        this.titulo = livro.getTitulo();
        this.autor = livro.getAutor();
        this.genero = livro.getGenero();
        this.ano = livro.getAno();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
