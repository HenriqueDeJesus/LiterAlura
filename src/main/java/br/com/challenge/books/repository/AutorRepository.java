package br.com.challenge.books.repository;

import br.com.challenge.books.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    @Query("""
    SELECT a FROM Autor a 
    WHERE a.anoDeNascimento <= :ano 
    AND (a.anoDeFalecimento IS NULL OR a.anoDeFalecimento > :ano)
    """)
    List<Autor> buscarAutoresVivosNoAno(@Param("ano") int ano);
    List<Autor> findByNomeContainingIgnoreCase(String nome);
    List<Autor> findByAnoDeNascimento(int ano);
    List<Autor> findByAnoDeFalecimento(int ano);
}
