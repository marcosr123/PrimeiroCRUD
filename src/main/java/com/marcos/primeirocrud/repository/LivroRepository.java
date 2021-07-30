package com.marcos.primeirocrud.repository;

import com.marcos.primeirocrud.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByDescricaoContainingIgnoreCase(String descricao);
}
