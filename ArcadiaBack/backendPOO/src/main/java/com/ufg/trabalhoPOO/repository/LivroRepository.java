package com.ufg.trabalhoPOO.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufg.trabalhoPOO.model.entidade.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, String> {
    List<Livro> findByTituloContaining(String titulo);

    Optional<Livro> findByIsbn(String isbn);

    List<Livro> findByUsuarioId(Long usuarioId);


}
