package br.com.challenge.books.repository;

import br.com.challenge.books.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByIdiomaContainingIgnoreCase(String idioma);
    List<Livro> findTop10ByOrderByDownloadDesc();
}
